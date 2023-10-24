package validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import model.entity.CustomerBean;

public class Validator {
	public static List<String> CustomerValidator(CustomerBean customer) {
		List<String> errors = new ArrayList<>();
		
		if (customer.getName() == null || customer.getName().isEmpty()) {
			errors.add("氏名は必須です。");
		} else if ( Pattern.matches("^.{1,20}$", customer.getName()) == false) {
			errors.add("氏名は20文字以内で入力してください");
		}
		
		if (customer.getNameKana() == null || customer.getNameKana().isEmpty()) {
			errors.add("かなは必須です。");
		} else if ( Pattern.matches("^.{1,20}$", customer.getNameKana()) == false) {
			errors.add("かなは20文字以内で入力してください");
		}
		
		if (customer.getPostCode() == null || customer.getPostCode().isEmpty()) {
			errors.add("郵便番号は必須です。");
		} else if ( Pattern.matches("[0-9]{7}", customer.getPostCode()) == false) {
			errors.add("郵便番号の形式が正しくありません");
		}
		
		if (customer.getAreaCode().equals("A000")) {
			errors.add("地区は必須です。");
		} 
		
		if (customer.getGender() == null || customer.getGender().isEmpty()) {
			errors.add("性別は必須です。");
		} 
		
		if (customer.getBirthday() == null || customer.getBirthday().isEmpty()) {
			errors.add("生年月日は必須です。");
		} else if ( Pattern.matches("[0-9]{6,8}", customer.getBirthday()) == false) {
			errors.add("生年月日の形式が正しくありません");
		}
		
		if (customer.getPhoneNumber() == null || customer.getPhoneNumber().isEmpty()) {
			errors.add("電話番号は必須です。");
		} else if ( Pattern.matches("0[0-9]{9,10}", customer.getPhoneNumber()) == false) {
			errors.add("電話番号の形式が正しくありません");
		}
		return errors;
	}
}
