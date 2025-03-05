package com.frankit.product_v1.common.enums;

import com.frankit.product_v1.common.error.BaseException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {

    //1000 벨리데이션 체크
    // 빈값_Error
    ID_INVALID("999", "유효하지 않은 ID "),
    EMPTY_ID("1000","선택한 정보가 없습니다."),
    EMPTY_NAME("1001","이름을 입력하지 않았습니다."),
    EMPTY_PHONE("1002","전화번호를 입력하지 않았습니다."),
    EMPTY_EMAIL("1003","이메일을 입력하지 않았습니다."),
    EMPTY_BIRTHDAY("1004","생일을 입력하지 않았습니다."),
    EMPTY_COMPANY("1005","회사명을 입력하지 않았습니다."),
    EMPTY_BUSINESS_NUM("1006","사업자 등록번호를 입력하지 않았습니다."),
    EMPTY_SERIAL("1007", "시리얼 번호를 입력하지 않았습니다"),
    EMPTY_LOGIN_DUPLICATION("1008", "이미 사용 중인 로그인 ID 입니다."),
    EMPTY_PASSWORD("1009", "비밀번호 암호화 과정에서 오류가 발생했습니다."),
    EMPTY_DATA_DUPLICATION("1010", "중복된 데이터로 인해 사용자 등록에 실패했습니다."),

    //2000 결과오류
    RESPONSE_FAIL_SEARCH("2002","조회를 실패했습니다."),
    RESPONSE_FAIL_INSERT("2003","등록을 실패했습니다."),
    RESPONSE_FAIL_UPDATE("2004","수정을 실패했습니다."),
    RESPONSE_FAIL_DELETE("2005","삭제를 실패했습니다."),
    RESPONSE_FAIL_DUPLICATION("2006","이미 등록된 정보입니다."),
    RESPONSE_FAIL_DATE("2007","날짜를 다시 확인해 주세요."),
    RESPONSE_FAIL_DUPLICATE_DATE("2008","중복된 날짜가 있습니다. 다시 확인해 주세요."),
    RESPONSE_FAIL_FOREIGN_KEY_DELETE("2009","참조 데이터가 있는 데이터는 삭제할 수 없습니다."),

    //3000 권한 오류
    // Spring Security 인증, 인가 권한
    AUTH_ENTRY_POINT("3000","인증정보가 유효하지 않습니다."),
    ACCESS_DENIED("3001","접근 권한이 없습니다."),
    FORBIDDEN("3002","잘못된 접근입니다."),
    AUTH_INVALID_SIGNATURE("3003","시그니처 오류"),
    AUTH_INVALID_TOKEN("3004","유효하지 않은 JWT 토큰"),
    AUTH_TOKEN_EXPIRATION("3005","토큰 기한 만료"),
    AUTH_TOKEN_UNSUPPORTED("3006","지원되지 않는 JWT 형식"),
    AUTH_TOKEN_COMPACT("3007","JWT token compact of handler are invalid."),
    AUTH_TOKEN_CREATION_ERROR("3008", "JWT 토큰 생성 과정에서 문제가 발생했습니다."),
    AUTH_NUMBER_EMPTY_ERROR("3009", "해당 인증번호를 포함하는 데이터가 없습니다."),
    AUTH_NUMBER_INVALID_ERROR("3010", "인증번호가 일치하지 않습니다."),

    //4000 시스템오류
    COMMON_SYSTEM_ERROR("4000","일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."), // 장애 상황
    COMMON_INVALID_PARAMETER("4001","요청한 값이 올바르지 않습니다."),
    COMMON_MOAPOS_SYSTEM_ERROR("4001","모아포스 시스템 오류 입니다."),
    COMMON_QR_SYSTEM_ERROR("4001","QR 시스템 오류 입니다."),
    COMMON_UNEXPECTED_REGISTRATION_ERROR("4002", "회원 등록 처리 중 예상치 못한 오류가 발생했습니다."),

    EMPTY_BANK("5001","존재하지 않는 은행 id 입니다."), // 존재하지 않는 bank id
    EMPTY_ROOM_CATEGORY("5002","존재하지 않는 유형구분 입니다."), // 존재하지 않는 RoomCategory
    EMPTY_ACCMMODATION_TYPE("5003","존재하지 않는 숙박시설구분 입니다."),// 존재하지 않는 RoomCategory
    EMPTY_STAY_BUSINESS("5004","존재하지 않는 숙박사업자 입니다."), // 존재하지 않는 숙박 시설 사업자 번호
    EMPTY_STAY_BOARD_TYPE ("5005","존재하지 않는 게시판 타입 입니다."),// 존재하지 않는 RoomCategory
    EMPTY_STAY_PENALTY_TYPE ("5006","존재하지 않는 환불 규정 타입 입니다."),// 존재하지 않는 stay_penalty 테이블 type
    EMPTY_STAY_ROOM_TYPE_ID("5007","존재하지 않는 룸 타입 id입니다."),
    EMPTY_STAY_BASE_SEASON_TYPE("5008","존재하지 않는 시즌 타입 입니다."),
    EMPTY_ADMIN_ID("5009","존재하지 않는 아이디 입니다."),
    EMPTY_STAY_ROOM_ID("5010","존재하지 않는 룸 id입니다."),

    //Consulting,
    EMPTY_BUSINESS_TYPE("5010","존재하지 않는 사업장 타입 입니다."), // 존재하지 않는 BusinessType
    EMPTY_FUNNEL_TYPE("5011","존재하지 않는 유입경로 타입 입니다."), // 존재하지 않는 Funnels
    EMPTY_CONSULTING_TYPE("5012","존재하지 않는 상담 타입입니다."), // 존재하지 않는 ConsultingType
    EMPTY_LOCATION_SURVEY_TYPE("5012","존재하지 않는 입지 조사결과입니다."), // 존재하지 않는 LocationSurvey

    // Holiday
    EMPTY_HOLIDAY_KIND("5013","존재하지 않는 공휴일 이름 입니다."), // 존재하지 않는 EditsKind

    // EditsKind
    EMPTY_EDITS_KIND("5014","존재하지 않는 구분 값입니다."), // 존재하지 않는 EditsKind
    // bannerKind
    EMPTY_BANNER_KIND("5015","존재하지 않는 유형구분 입니다."), // 존재하지 않는 bannerKind

    // Domain Specific Errors
    INVALID_DATE_RANGE("5016", "날짜 범위가 유효하지 않습니다."),
    INVALID_DIMENSIONS("5017", "유효하지 않은 치수 값입니다."),
    INVALID_TITLE("5018", "제목을 입력하지 않았습니다."),

    EMPTY_ADMIN_NOTICE_TYPE("5019","존재하지 않는 공지 타입 입니다."),
    INVALID_IS_USE("5020", "사용유무가 선택되지 않았습니다."),
    EMPTY_SERVICE_STATUS("5021","존재하지 않는 운영 상태 값입니다."),

    EXIST_SEASON_DATE("5022","이미 존재하는 시즌일 입니다."),
    POP_BILL_ERROR("5023","팝빌 에러 입니다."),
    POP_BILL_SEND_ERROR("5024","팝빌 문자 발송 실패" ),

    ALARM_SMS_KIND_TYPE("5024","존재하지 않는 알람 메세지 구분 타입 입니다."),
    OPTION_KIND_TYPE("5024","존재하지 않는 옵션 구분 타입 입니다."),
    TEMPLATE_KIND_TYPE("5025","존재하지 않는 구분 타입 입니다.") ,
    POP_BILL_POINT_BALANCE("5026","팝빌 잔여포인트가 부족" ),
    INTERNAL_SERVER_ERROR("5027","기타 서버 에러 입니다." ),
    EXIST_RESERVATION_BLOCK("5028","이미 예약이 존재하는 방 입니다." ),
    EMPTY_CHECK_IN("5029","시작일을 입력해 주세요" ),
    EMPTY_CHECK_OUT("5030","종료일을 입력해 주세요" ),
    EMPTY_SEASON("5031","시즌일이 없습니다." ),
    CANCEL_AMOUNT_EXCEEDS_PAYMENT("5032", "취소 금액이 결제 금액을 초과합니다."),


    PAYMENT_CANCEL_FAIL("6001", "결제 취소에 실패했습니다.");



    private String errorCode;
    private String errorMsg;

    public static String getMessage(String errorCode) {
        return Arrays.stream(ErrorCode.values())
                .filter(e -> e.getErrorCode().equals(errorCode))
                .map(ErrorCode::getErrorMsg)
                .findFirst().orElseGet(() -> String.valueOf(new BaseException(ErrorCode.COMMON_INVALID_PARAMETER)));
    }
}
