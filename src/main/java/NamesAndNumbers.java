import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NamesAndNumbers {
	private Map<String, ArrayList<String>> NamesAndNumbersHashMap = new HashMap<String, ArrayList<String>>(); 
	
	public void PutStrToNamesAndNumbersHashMap(String str){
		ArrayList<String> CurrentNumbersArrayList = new ArrayList<String>();
		//разбиваем строку на слова
		String NameAndNumbersArray[] = str.split("\\+");
		//создаем список номеров
		for (int i = 1; i < NameAndNumbersArray.length; i++){
			CurrentNumbersArrayList.add("+" + NameAndNumbersArray[i]);
		}
		//заносим имя и номера в HashMap
		NamesAndNumbersHashMap.put(NameAndNumbersArray[0].trim(), CurrentNumbersArrayList);
	}
	
	public boolean CheckNameInHashMap(String NameStr) {
		if (NamesAndNumbersHashMap.containsKey(NameStr) == false) return false;
		else return true;
	}
	
	public void PrintNumbersByName(String NameStr){
		ArrayList<String> CurrentNumbersArrayList = new ArrayList<String>();
		CurrentNumbersArrayList = NamesAndNumbersHashMap.get(NameStr);
		for(int i = 0; i < CurrentNumbersArrayList.size(); i++)
		{
			System.out.println((i+1) + ". " + CurrentNumbersArrayList.get(i));
		}
	}
}
