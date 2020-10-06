package controller;

import model.Dictionary;
import model.Word;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataController {

    private FileInputStream fis;
    private ObjectInputStream ois;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private Scanner scanner;

//    /**
//     * Thêm từ điển từ dòng lệnh.
//     * @return Từ điển sau khi thêm.
//     */
//    public Dictionary insertFromCommandline(Dictionary dictionary) {
//        scanner = new Scanner(System.in);
//        int numberWord = scanner.nextInt();
//        scanner.nextLine();
//        for (int i = 1; i <= numberWord; i++) {
//            Word word = new Word();
//            word.setWordTarget(scanner.nextLine());
//            word.setWordExplain(scanner.nextLine());
//            dictionary.addWord(word);
//        }
//        scanner.close();
//        return dictionary;
//    }

//    /**
//     * Hiện từ có trong danh sách từ điển.
//     * @param dictionary Từ điển.
//     */
//    public void showAllWord(Dictionary dictionary) {
//        System.out.println("No - English - Vietnamese");
//        for (int i = 0; i < dictionary.size(); i++) {
//            System.out.print((i + 1) + " - " + dictionary.getWord(i).toString() + "\n");
//        }
//    }

    /**
     * Lấy từ điển từ trong file.
     * @param dictionary Từ điển.
     * @param fileName Tên file.
     * @return Từ điển.
     */
    public Dictionary insertFromFile(Dictionary dictionary, String fileName) {
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);

            dictionary = (Dictionary)ois.readObject();

            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    public Dictionary addDataToDictionary(Dictionary dictionary, String fileName) {
        try {
            Scanner sc = new Scanner(Paths.get(fileName), "UTF-8");
            int i = 6900; // > 7000 sẽ bị lỗi
            String wordExplain = "";
            String wordTarget = "";
            while (i != 0) {
                String tmp = sc.nextLine();
                if (tmp.startsWith("@")) {
                    if (!wordTarget.equals("")) {
                        Word word = new Word(wordTarget, wordExplain);
                        dictionary.addWord(word);
                        wordTarget = "";
                        wordExplain = "";
                    }
                    String[] tmpSplit = tmp.split(" /");
                    wordTarget = tmpSplit[0].substring(1, tmpSplit[0].length());
                    wordExplain = wordExplain + " /" + tmpSplit[1] + "\n";
                }
                else {
                    wordExplain = wordExplain + " " + tmp + "\n";
                }
                i --;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

//    /**
//     * Tạo word từ dòng.
//     * @param data dòng dữ liệu.
//     * @return word.
//     */
//    private Word createWordFromData(String data) {
//        String[] list = data.split("-");
//        Word word = new Word(list[0], list[1]);
//        return word;
//    }

//    /**
//     * Thêm một word từ commandline
//     * @param dictionary Thư viện trước khi thêm.
//     * @return Thư viện sau khi thêm.
//     */
//    public Dictionary addWordFromCommandLine(Dictionary dictionary) {
//        scanner = new Scanner(System.in);
//        Word word = new Word();
//        word.setWordTarget(scanner.nextLine());
//        word.setWordExplain(scanner.nextLine());
//        scanner.close();
//        dictionary.addWord(word);
//        return dictionary;
//    }

//    /**
//     * Xóa một từ khỏi thư viện.
//     * @param dictionary Thư viện.
//     * @return Thư viện.
//     */
//    public Dictionary removeWordFromCommandLine(Dictionary dictionary) {
//        scanner = new Scanner(System.in);
//        String word = scanner.nextLine();
//        for (int i = 0; i < dictionary.size(); i++) {
//            if (dictionary.getWord(i).getWordTarget().equals(word)) {
//                dictionary.removeWord(i);
//            }
//        }
//        scanner.close();
//        return dictionary;
//    }

//    /**
//     * Sửa nghĩa tiếng Việt của từ.
//     * @param dictionary Từ điển trước.
//     * @return Từ điển sau.
//     */
//    public Dictionary editWordFromCommandLine(Dictionary dictionary) {
//        scanner = new Scanner(System.in);
//        String word = scanner.nextLine();
//        String wordExplain = scanner.nextLine();
//        for (int i = 0; i < dictionary.size(); i++) {
//            if (dictionary.getWord(i).getWordTarget().equals(word)) {
//                dictionary.getWord(i).setWordExplain(wordExplain);
//            }
//        }
//        scanner.close();
//        return dictionary;
//    }


    /**
     * Xuất từ điển ra file.
     * @param dictionary Từ điển.
     * @param fileName tên file.
     */
    public void dictionaryExportToFile(Dictionary dictionary, String fileName) {
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(dictionary);

            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
