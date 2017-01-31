import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
// Alohaクラス
public class Aloha2 {
	//メインメソッド
	public static void main(String[] args) {
		// windowmanを新規作成
		windowman wman = new windowman();

	}
}
// windowmanクラス
class windowman implements ActionListener{
	//  データ
	String name;	//名前
	JFrame frame;	//ウィンドウ
	JTextField order;	//注文を書くところ
	JButton button;		//ボタン
	JPanel orderPanel;	//パネル
	JPanel buttonPanel;	

	//命令（メソッド）
	public windowman(){
		//名前を決める
		this.name = "Hayahide";
		//ウィンドウを作る
		frame = new JFrame(this.name);
		frame.setLocation(400 , 400);	//場所
		frame.setSize(300 , 300);		//サイズ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//パーツを新規作成（new）する
		order = new JTextField("ヒレカツ定食" , 20);
		button = new JButton("注文");
		button.addActionListener(this);
		orderPanel = new JPanel();
		buttonPanel = new JPanel();

		//のせる
		//パネルに入力欄やボタンをのせる
		orderPanel.add(order);
		buttonPanel.add(button);

		//ウィンドウにパネルをのせる
		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1)); //並べ方決める
		con.add(orderPanel);
		con.add(buttonPanel);
		//ウィンドウを表示する
		frame.setVisible(true);
	}
	//クリックされた時の処理
	public void actionPerformed(ActionEvent ae){
		//注文を、調べる
		String chumon = order.getText();

		//表示する(git bushの画面に)
		System.out.println(chumon);

		//ファイル関係のデータ
		File outFile;
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		//ファイルに書いて保存する
		try {
			//ファイルを開く
			fos = new FileOutputStream("order.txt" , true);
			osw = new OutputStreamWriter(fos , "UTF-8");
			bw = new BufferedWriter(osw);
			pw = new PrintWriter(bw);
			//ファイルに書き込む
			pw.println(this.order.getText());
		} catch(IOException e) {
			//エラーメッセージ表示
			System.out.println("IO error");
		} finally {
			//ファイルを閉じる
			try {
			bw.close();
			pw.close();
			} catch(IOException e){
			System.out.println("IO error at closing.");
			}
		}
	}
}