import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Parser {
	private static BufferedReader reader;

	public static void readSecurity(String name) throws IOException {
		String line = read(name);
    Map<String, Object> sec = parse(line);
    if (name.equals("BOND")) Security.BOND = new Security("BOND", (ArrayList<Object>) sec.get("sell"), (ArrayList<Object>) sec.get("buy"));
    else if (name.equals("VALBZ")) Security.VALBZ = new Security("VALBZ", (ArrayList<Object>) sec.get("sell"), (ArrayList<Object>) sec.get("buy"));
    else if (name.equals("VALE")) Security.VALE = new Security("VALE", (ArrayList<Object>) sec.get("sell"), (ArrayList<Object>) sec.get("buy"));
    else if (name.equals("GS")) Security.GS = new Security("GS", (ArrayList<Object>) sec.get("sell"), (ArrayList<Object>) sec.get("buy"));
    else if (name.equals("MS")) Security.MS = new Security("MS", (ArrayList<Object>) sec.get("sell"), (ArrayList<Object>) sec.get("buy"));
    else if (name.equals("WFC")) Security.WFC = new Security("WFC", (ArrayList<Object>) sec.get("sell"), (ArrayList<Object>) sec.get("buy"));
    else if (name.equals("XLF")) Security.XLF = new Security("XLF", (ArrayList<Object>) sec.get("sell"), (ArrayList<Object>) sec.get("buy"));
    else throw new IOException("invalid security name!");
	}
	
	private static String read(String fileName) throws IOException {
		reader = new BufferedReader(new FileReader(fileName));
		String line = reader.readLine();
    reader.close();
    return line;
	}
	
	private static Map<String, Object> parse(String jsonStr) {
		Type typeOfObjectsList = new TypeToken<Map<String, Object>>() {}.getType();
		Map<String, Object> out = new Gson().fromJson(jsonStr, typeOfObjectsList);
		return out;
	}
}
