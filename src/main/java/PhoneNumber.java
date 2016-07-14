import java.util.Scanner;

public class PhoneNumber {
	private static Scanner scan;
	
	private static MailSender mailSender= new MailSender("tst.send.message@gmail.com", "1q2w3e1a2s3dR");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str1 = "Иванов И.И. +8 800 2000 500 +8 800 2000 600";
		String str2 = "Петров П.П. +8 800 2000 700";
		String str3 = "Сидоров С.С. +8 800 2000 800 +8 800 2000 900 +8 800 2000 000";
		
		NamesAndNumbers nn = new NamesAndNumbers();
		
		nn.PutStrToNamesAndNumbersHashMap(str1);
		nn.PutStrToNamesAndNumbersHashMap(str2);
		nn.PutStrToNamesAndNumbersHashMap(str3);
		
		scan = new Scanner(System.in);
		System.out.print("Введите Фамилию_Инициал.Инициал. : ");
		String NameStr = scan.nextLine();

		
		if (nn.CheckNameInHashMap(NameStr) == true){
			nn.PrintNumbersByName(NameStr);
		}
		else System.out.println("Такого имени в базе нет.");
		
		mailSender.Send("Запуск программы", "Программа запущена.", "tst.send.message@gmail.com", "kluchnikov.dv@gmail.com");
	}
}
