package com.kh.semi.member.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpdatePasswordDto {
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message="비밀번호 값은 영어 / 숫자만 입력가능 합니다.")
	@Size(min=4, max=20, message="비밀번호 값은 4글자 이상 20글자 이하만 사용할 수 있습니다.")
	@NotBlank(message="비밀번호 값은 버어있을 수 있습니다.")
	private String memberPwd;
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message="비밀번호 값은 영어 / 숫자만 입력가능 합니다.")
	@Size(min=4, max=20, message="비밀번호 값은 4글자 이상 20글자 이하만 사용할 수 있습니다.")
	@NotBlank(message="비밀번호 값은 버어있을 수 있습니다.")
	private String updatePwd;
}
