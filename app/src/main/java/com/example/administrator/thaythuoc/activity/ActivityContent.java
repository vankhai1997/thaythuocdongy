package com.example.administrator.thaythuoc.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.example.administrator.thaythuoc.R;

import java.io.IOException;
import java.io.InputStream;

public class ActivityContent extends AppCompatActivity {
    private WebView tvContent;
   private String tContents = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        initsView();
//        initsContent();
        initsAsytask();

    }

    private void initsView() {
        tvContent = findViewById(R.id.tv_content);
    }
public void initsAsytask(){
    new AsyncTask<Void, Void, String>() {
        @Override
        protected String doInBackground(Void... voids) {
            LoadData("chedoanvosinh.html");

            return tContents;
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            Log.d("aaaa", "doInBackground: "+tContents);
            tvContent.getSettings().setJavaScriptEnabled(true);
            tvContent.loadUrl("file:///android_asset/ok.html");
//            tvContent.setText(Html.fromHtml(tContents));

        }
    }.execute();

}
    public String LoadData(String inFile) {



        try {
            InputStream stream = getAssets().open(inFile);
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
        }
        return tContents;

    }



    private void initsContent() {
        String htmlcontent =
                "\t<h2><font color=\"red\">Sỏi tiết niệu nên và  không nên ăn gì?</font></h2>" +
                        " "+
                        "<p>\nSỏi tiết niệu được&nbsp;hình thành do sự lắng đọng các  khoáng chất trong niệu quản (lẽ ra các khoáng chất này phải được đào thải ra  ngoài cơ thể qua đường tiết niệu). Sỏi tiết niệu (sỏi niệu quản) thường có biểu  hiện lâm sàng không mấy rõ ràng và dễ nhầm với những bệnh khác. Siêu âm hoặc chụp  X quang là một trong những phương pháp phát hiện và chẩn đoán sỏi tiết niệu một  cách chính xác. Sỏi niệu quản làm tắc nghẽn đường lưu thông của nước tiểu và  gây ra nhiều biến chứng nguy hiểm. Ngoài sử dụng thuốc điều trị thì người bệnh  sỏi niệu quản nên kết hợp chế độ ăn uống, sinh hoạt hợp lý để đánh tan sỏi cũng  như ngăn ngừa sỏi niệu quản tái phát. Phòng khám Đông y Nguyễn Hữu Toàn sẽ chia  sẻ với các bạn một số kiến thức về chế độ ăn uống thích hợp cho bệnh nhân sỏi  niệu quản (sỏi tiết niệu)"+"\n" +
                        "<p>Những  thực phẩm và đồ uống nên sử dụng khi bị sỏi tiết niệu:"+"" +
                        "<p>Trước  hết người  bị sỏi tiết niệu nên uống từ 3-4 lít nước/1 ngày. Nước tiểu sẽ giúp đào thải những  viên sỏi tiết niệu có kích thước nhỏ ra ngoài được. Ngoài ra cũng giúp đào thải  độc tố ra khỏi cơ thể.\n" +
                        "<p>Người bị sỏi tiết niệu  nên ăn nhạt. Cố gắng hạn chế lượng muối trong các bữa ăn sẽ có tác dụng giảm  canxi trong nước tiểu, giảm nguy cơ hình thành sỏi canxi. Hạn chế sử dụng các  loại thực phẩm được chế biến sẵn, đồ ăn nhanh, vì những thực phẩm này thường có  hàm lượng muối cao hơn so với các thực phẩm tươi.</p>\n" +
                        "<p>Bệnh nhân bị sỏi tiết  niệu nên ăn nhiều các thực phẩm giàu chất xơ (gồm cả chất xơ tan trong nước và  chất xơ không tan trong nước). Chất xơ thường có nhiều trong các loại rau xanh,  nấm, cà rốt, chuối, lê, bơ, rau mồng tơi, lúa mì, lúa mạch, … Chất xơ này kết hợp  với canxi trong ruột sẽ được bài tiết qua đường hậu môn thay vì thông qua thận,  đồng thời còn giúp tăng tốc độ chuyển động của các chất thông qua ruột, vì vậy  sẽ có ít thời gian hơn cho canxi hấp thụ.</p>\n" +
                        "<p>Người bị sỏi niệu quản  vẫn nên tiêu thụ các thực phẩm giàu canxi. Nếu như trước đây bệnh nhân sỏi thận,  sỏi niệu quản thường được khuyên hạn chế canxi trong bữa ăn hàng ngày thì nhiều  nghiên cứu hiện nay đã chỉ ra rằng: chế độ ăn uống đủ canxi mỗi ngày có tác dụng  làm giảm tỷ lệ bị sỏi. Những người bị sỏi tiết niệu loại sỏi canxi oxalate có  thể bổ sung 800mg canxi tự nhiên mỗi ngày. Bệnh nhân sỏi tiết niệu nên bổ sung  canxi bằng việc uống sữa ít béo và sử dụng các sản phẩm từ sữa.</p>\n" +
                        "<p>Nên uống nước cam tươi  chanh tươi, nước bưởi những loại thức uống này chứa nhiều cytrat giúp chống lại  sự tái tạo sỏi niệu.\n" +
                        "<p>Nên tập thể dục đều đặn  hàng ngày giúp tăng cường sức khỏe và cũng dễ dàng giúp đẩy sỏi ra ngoài.\n" +
                        "<p><strong><font color=\"red\">Những  thực phẩm người bị sỏi tiết niệu nên hạn chế</font></strong>\n" +
                        "<p>Nên hạn chế một số thực  phẩm chứa axit oxalic hoặc oxalate như: rau bina, dâu tây, chocolate, cám lúa  mì, hạt, củ cải đường, trà,… vì những thực phẩm này làm tăng hàm lượng oxalate  trong nước tiểu. \n" +
                        "<p>Không nên tiêu thụ nhiều  các loại thực phẩm giàu vitamin C vì cơ thể có thể chuyển đổi vitamin C thành  oxalate, một chất làm tăng nguy cơ hình thành sỏi niệu quản. Người bị sỏi niệu  quản chỉ nên tiêu thụ khoảng 500mg vitamin C mỗi ngày.\n" +
                        "<p>Hạn chế đường trong các  bữa ăn hàng ngày vì đường có thể làm gia tăng tình trạng sỏi niệu quản.\n" +
                        "<p>Hạn chế tiêu thụ  protein có nguồn gốc động vật vì chúng chứa nhiều purin sẽ phân hủy thành axit  uric trong nước tiểu, là một trong những nguyên nhân hình thành nên sỏi niệu quản.\n" +
                        "<p>Hạn chế sử dụng bia, rượu,  đồ uống có ga, có cồn.\n" +
                        "<p>Hạn chế sử dụng các thực  phẩm nướng, rán, xào, những thực phẩm chứa nhiều dầu, mỡ.\n" +
                        "<p>Hạn chế đường và  protein động vật\n" +
                        "<p>Tuyệt đối không nên nhịn  đi tiểu.\n" +
                        "<p>Trên đây là một số lưu  ý về chế độ ăn uống, sinh hoạt cho bệnh nhân sỏi niệu quản. Hy vọng với những  chia sẻ này bệnh nhân sỏi niệu quản sẽ cảm thấy dễ chịu hơn, tránh bệnh tái  phát và nhanh đào thải được sỏi ra bên ngoài.\n" +
                        "<Chú ý: Người bệnh cần  nhớ, chế độ ăn uống chỉ cso tác dụng phần nào, đối với trường hợp bệnh nhân bị  sỏi niệu quản cần điều trị bằng thuốc. Phòng khám Đông&nbsp; y Nguyễn Hữu Toàn có bài thuốc gia truyền đặc  trị sỏi thận, sỏi tiết niệu. Nhiều bệnh nhân uống 20 ngày thuốc đã đái ra sỏi.  Vui lòng liên hệ 18006834 – miễn phí cước gọi để được tư vấn.\n" +
                        "<em>Theo thaythuoccuaban.com</em>\n" +
                        "&nbsp;</p>\n" +
                        "\n" +
                        "\t\t\n";


//        tvContent.setText(android.text.Html.fromHtml(htmlcontent));
    }
}
