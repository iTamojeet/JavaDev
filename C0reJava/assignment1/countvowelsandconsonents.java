// Solution to question 2
class countVowelsAndConsonents {
    // This method coumts all the vowels
    static int countVowels(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        return count;
    }
    // This method coumts all the consonants
    static int countConsonants(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                continue;
            }else{
                count++;
            }
        }
        return count;
    }
    // Main method or thread
    public static void main(String[] args) {
        String str = args[0];
        if(str.length()==0){
            System.out.println("Please enter a valid string");
        }else{
            int vowels = countVowels(str.toLowerCase());
            int consonents = countConsonants(str.toLowerCase());
            System.out.println("Your console entered name is: "+str);
            System.out.println("Total vowels in your name: " + vowels);
            System.out.println("Total consonents in your name: " + consonents);
        }
    }
}
