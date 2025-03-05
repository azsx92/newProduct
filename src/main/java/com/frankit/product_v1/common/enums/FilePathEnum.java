package com.frankit.product_v1.common.enums;

import com.frankit.product_v1.common.error.BaseException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum FilePathEnum {
    STAY(1L, "stay"),
    STAY_ROOM(2L, "stayRoom"),
    STAY_PRODUCT(3L, "stayProduct"),
    FACILITY(4L, "facility"),
    BANNER(5L, "banner"),
    OUR_NEWS(6L, "ourNews"),
    POPUP_NOTICE(7L, "popupNotice"),
    NOTICE(8L, "notice"),
    STAY_OPTION(9L, "stayOption"),
    STAY_BOARD(10L, "stayBoard"),
    OTHER(11L, "other");

    private Long code;
    private String value;

    public static String getFileFolderName(Long folderNum) {
        return Arrays.stream(FilePathEnum.values())
                .filter(e -> Objects.equals(e.getCode(), folderNum))
                .map(FilePathEnum::getValue)
                .findFirst().orElseGet(() -> String.valueOf(new BaseException(ErrorCode.COMMON_INVALID_PARAMETER)));
    }


    public static Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        for (FilePathEnum filePath : FilePathEnum.values()) {
            map.put(String.valueOf(filePath.getCode()), filePath.getValue());
        }
        return map;
    }
}
