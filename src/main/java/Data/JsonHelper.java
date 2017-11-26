package Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonHelper {
	public static Pattern[] regs = { Pattern.compile("\\\\"), Pattern.compile("\r\n|\n|\r"), Pattern.compile("\t"),
			Pattern.compile("\"") };
	//compile - 정규식을 true/false로 변환해서 패턴에 저장 replace도 패턴을 컴파일해서 불러오지만 매번해야하기 때문에 overhead가 생김
	public static String[] replacers = { "\\\\\\\\", "\\\\n", "\\\\t", "\\\\\"" };

	public static String getJsonAdaptableString(String text) {
		String result = text;
		Matcher matcher;
		for (int i = 0; i < regs.length; ++i) {
			matcher = regs[i].matcher(result);
			result = matcher.replaceAll(replacers[i]);
		}
		return result;
	}
}
