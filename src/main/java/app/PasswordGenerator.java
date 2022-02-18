package app;

/**
 * Класс генератора пароля
 *
 * @author Покальнетов Павел
 * @version 1.1
 */

public class PasswordGenerator {
    /**
     * строка сгенерированного пароля
     */
    private String passString = "";
    /**
     * длина пароля
     */
    private int passLen = 0;
    /**
     * набор символов для генерации пароля
     */
    //private String passChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz0123456789";
    private String passChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz0123456789" + "!@#$%^&*()_+-=/?,.`~<>;:\"'{}[]|";
    private int passCharLen;

    /**
     * Конструктор - создание генератора с базовым набором символов и длинной 8 знаков
     *
     * @see PasswordGenerator#PasswordGenerator(String)
     * @see PasswordGenerator#PasswordGenerator(String, int)
     * @see PasswordGenerator#PasswordGenerator(int)
     */
    public PasswordGenerator() {
        this.passLen = 8;
        this.passCharLen = this.passChar.length();
        this.passGenerate();
    }

    /**
     * Конструктор - создание генератора с заданным базовым набором символов и длиной пароля по умолчанию =8
     *
     * @param str - строка - набор символов для генерации рароля
     */
    public PasswordGenerator(String str) {

        this.setPassChar(str);
        if (this.passLen == 0) {
            this.passLen = 6;
        }
        this.passGenerate();
    }

    /**
     * Конструктор - создание генератора с заданным базовым набором символов
     * и заданной длиной пароля
     *
     * @param len - длина пароля
     */
    public PasswordGenerator(int len) {
        /**
         * @param
         */
        this.setLen(len);
        this.passCharLen = this.passChar.length();
        this.passGenerate();
    }

    /**
     * Конструктор - создание генератора с заданным базовым набором символов и заданной длиной пароля
     *
     * @param str - набор символов для генератора
     * @param len - длина пароля
     */
    public PasswordGenerator(String str, int len) {
        this.setLen(len);
        this.setPassChar(str);
        this.passGenerate();
    }

    /**
     * Установить набор символов для генерации пароля
     *
     * @param str - строка - набор символов для генератора
     */
    public void setPassChar(String str) {
        if ("" != str) {
            this.passChar = str;
            this.passCharLen = str.length();
        }
    }

    /**
     * Установить длину генерируемого пароля
     *
     * @param len - длина генерируемого пароля
     */
    public void setLen(int len) {
        if (len > 0) {
            this.passLen = len;
        }
    }

    /**
     * Сгенерировать и получить новый пароль
     *
     * @return - сгенерированный пароль
     * @see PasswordGenerator#getNewPass(int)
     * @see PasswordGenerator#getNewPass(String, int)
     */
    public String getNewPass() {
        this.passGenerate();
        return this.passString;
    }

    /**
     * Сгенерировать и получить новыq пароль определенной длины
     *
     * @param len - длина пароля
     * @return - сгенерированный пароль
     * @see PasswordGenerator#getNewPass()
     * @see PasswordGenerator#getNewPass(String, int)
     */
    public String getNewPass(int len) {
        this.setLen(len);
        this.passGenerate();
        return this.passString;
    }

    /**
     * Сгененрировать и получить пароль из определенного набора символов и заданной длиной
     *
     * @param str - набор символов для генератора
     * @param len - длина пароля
     * @return - сгенерированный пароль
     * @see PasswordGenerator#getNewPass()
     * @see PasswordGenerator#getNewPass(int)
     */
    public String getNewPass(String str, int len) {
        this.setLen(len);
        this.setPassChar(str);
        this.passGenerate();
        return this.passString;
    }

    /**
     * генерирует пароль
     * записывает его в passString
     */
    private void passGenerate() {
        String password = "";
        int index = 0;
        int maxRnd = this.passCharLen;
        for (int i = 0; i < this.passLen; i++) {
            index = (int) (maxRnd * Math.random());
            password += this.passChar.charAt(index);
        }
        this.passString = password;
    }

    /**
     * Получить последний сгенерированный пароль
     *
     * @return - строка пароля
     */
    public String getPass() {
        return this.passString;
    }

    /**
     * получить сводную информацию о состоянии объекта и хначения его полей
     */
    public void _info() {
        System.out.printf(
                "Current password: %s\n" +
                        "Password len: %s\n" +
                        "Base string: %s\n",
                this.passString,
                this.passLen,
                this.passChar);
    }
}
    