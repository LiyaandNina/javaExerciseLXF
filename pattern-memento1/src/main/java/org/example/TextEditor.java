package org.example;

public class TextEditor {
    private StringBuilder sb = new StringBuilder();

    public void add(char ch) {
        sb.append(ch);
    }

    public void add(String str) {
        sb.append(str);
    }

    public void delete() {
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String getState() {
        return this.sb.toString();
    }

    public void setState(String sbBak) {
        this.sb.delete(0, this.sb.length());
        this.sb.append(sbBak);
    }

    public void print() {
        System.out.println(sb);
    }
}
