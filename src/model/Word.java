package model;

import java.io.Serializable;

public class Word implements Serializable {
    private String wordTarget; // Từ mới.
    private String wordExplain; // Giải nghĩa.

    /**
     * Khởi tạo không tham số.
     */
    public Word() {
    }

    /**
     * Khởi tạo có tham số.
     * @param wordTarget Từ mới.
     * @param wordExplain Giải nghĩa.
     */
    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }

    /**
     * Lấy từ tiếng Anh.
     * @return Trả về từ tiếng Anh.
     */
    public String getWordTarget() {
        return wordTarget;
    }

    /**
     * Khởi tạo từ tiếng Anh.
     * @param wordTarget Từ tiếng Anh.
     */
    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    /**
     * Lấy nghĩa tiếng Việt.
     * @return Trả về nghĩa tiếng Việt.
     */
    public String getWordExplain() {
        return wordExplain;
    }

    /**
     * Thiết lập nghĩa tiếng Việt.
     * @param wordExplain Nghĩa tiếng Việt.
     */
    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    @Override
    public String toString() {
        return wordTarget + " - " + wordExplain;
    }
}
