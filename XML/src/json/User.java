/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

public class User {

    public enum Gender {

        MALE, FEMALE
    };

    public static class Name {

        private String first, last;

        public Name(String _first, String _last) {
            this.first = _first;
            this.last = _last;
        }

        public String getFirst() {
            return first;
        }

        public String getLast() {
            return last;
        }

        public void setFirst(String s) {
            first = s;
        }

        public void setLast(String s) {
            last = s;
        }
    }
    private Gender gender;
    private Name name;
    private boolean isVerified;

    public Name getName() {
        return name;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(Name n) {
        name = n;
    }

    public void setVerified(boolean b) {
        isVerified = b;
    }

    public void setGender(Gender g) {
        gender = g;
    }
}