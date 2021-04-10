package com.example.gameloto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText mEdtSMin, mEdtSMax;
    TextView mTvResult;
    Button mBtnRandom, mBtnAddRange, mBtnReset;

    String mTextSMin = "";
    String mTextSMax = "";
    Random mRandom = null;
    String mTextResult = "";

    List<String> mArrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // Math
        1: làm tròn
            float st1 = 1.999f;
            float valueSt1 = Math.round(st1);   // làm tròn 0.5
            double valueSt2 = Math.ceil(Double.parseDouble(st1 +""));   // làm tròn lên
            double valueSt3 = Math.floor(Double.parseDouble(st1 + "")); // Làm tròn xuống
            Log.d("Test", valueSt3 + "");
        2. random
            double value = Math.round(Math.random()*5); // random từ 0 -> 5
            double value = Math.floor(Math.random()*6); // random từ 0->5 với xác xuất các số bằng nhau
            Log.d("Test", value + "");
        3. Random in Java
            Random random = new Random();
            int max = 127;
            int min = 5;
    //        int value = random.nextInt(10); // random 0-> 9
            int value = random.nextInt(max - min + 1)+min; // Random from min->max
            Log.d("Test", value + "");


            Cách định nghĩa một phương thức
            1. Phạm vi hoạt động.
            2. Kiểu dữ liệu trả về.
            3. Tên phương thức

            Khởi tạo mảng
            ArrayList<String> arrNames = new ArrayList<>();
            // Thêm dữ liệu
            arrNames.add("Teo");
            arrNames.add("Tí");
            // Xóa dữ liệu
            arrNames.remove(1); // Xóa "Tí"
            // Cập nhật phần tử
            arrNames.set(0, "Tèo");

         */

//        Task 1: Bàn Phím phải là số
//        Task 2: Chỉ nhập tối đa 3 chữ số
//        Task 3: Kiểm tra số nhập vào đủ chưa, nếu không thì xuất ra thông báo
//        Task 4: Ngoài việc nhấn Random để random thì có thể nhấn nút action done

//        Task 5: Add range xử lý validate và add dữ liệu vào mảng.
//        Task 4: Reset sẽ xóa dữ liệu edittext, mảng, kết quả

        Init();
        mArrList = new ArrayList<>();
        mRandom = new Random();
        mBtnAddRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateForm()) return;    // Dừng phương thức

                // Chuyển chuỗi thành số
                int sMax = Integer.parseInt(mTextSMax);
                int sMin = Integer.parseInt(mTextSMin);

                if(sMin>= sMax){
                    sMax = sMin + 1;
                }

                mEdtSMax.setText(String.valueOf(sMax));

                mArrList.clear();
                for (int i = sMin; i <= sMax; i++) {
                    mArrList.add(String.valueOf(i));
                }
                Toast.makeText(MainActivity.this, "Hoàn tất việc thêm giá trị", Toast.LENGTH_SHORT).show();
                disableView(mBtnAddRange);
                disableView(mEdtSMax);
                disableView(mEdtSMin);
            }
        });

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mArrList.size() >0){
                    int index = mRandom.nextInt(mArrList.size());
                    int value = Integer.parseInt(mArrList.get(index));
//                    if (mArrList.size() == 1){
//                        mTextResult += value;
//                    }else{
//                        mTextResult += value + " - ";
//                    }
                    mTextResult += value + " - ";
                    if (mArrList.size() == 1){
                        // subString (vị trí bắt đầu cắt, vị trí kết htucs căt)
                        mTextResult = mTextResult.substring(0,mTextResult.length()-3);
                    }
                    mTvResult.setText(mTextResult);
                    mArrList.remove(index);
                }else{
                    Toast.makeText(MainActivity.this, "Hết số để Random!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa dữ liệu
                mEdtSMax.setText("");
                mEdtSMin.setText("");
                mArrList.clear();
                mTvResult.setText("");
                mTextResult = "";
                // Bật tương tác cho view
                enableView(mEdtSMin);
                enableView(mEdtSMax);
                enableView(mBtnAddRange);
            }
        });
        mEdtSMax.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE)
//                    validateForm();
//                int sMax = Integer.parseInt(mTextSMax);
//                int sMin = Integer.parseInt(mTextSMin);
//
//                if(sMin>= sMax){
//                    sMax = sMin + 1;
//                }
//                mEdtSMax.setText(String.valueOf(sMax));
//                mRandom = new Random();
//                int value = mRandom.nextInt(sMax- sMin +1) + sMin;
//
//                mTextResult += value + " - ";
//
//                mTvResult.setText(mTextResult);
                    mBtnAddRange.performClick();
                return true;

            }
        });
    }
    // Xử lý giá trị đầu vào edittext
    private boolean validateForm(){
        mTextSMin = mEdtSMin.getText().toString();
        mTextSMax = mEdtSMax.getText().toString();

        if (mTextSMin.isEmpty()||mTextSMax.isEmpty()){
            Toast.makeText(MainActivity.this, "Bạn chưa nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void Init() {
        mEdtSMin = findViewById(R.id.textViewSomin);
        mEdtSMax = findViewById(R.id.textViewSomax);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mTvResult = findViewById(R.id.textViewKetqua);
        mBtnAddRange = findViewById(R.id.buttonAddRange);
        mBtnReset = findViewById(R.id.buttonReset);
    }
    private  void enableView(View v){
        v.setEnabled(true);
    }
    private  void disableView(View v){
        v.setEnabled(false);
    }
}