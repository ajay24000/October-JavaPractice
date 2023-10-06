package Week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FifthCode {
    private static final String FILE_PATH = "C://Datasets/MentorMentee.csv";

    public static void main(String[] args) {
        // Read the CSV file and store the data
        List<String[]> mentorMenteeData = readCSVFile(FILE_PATH);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the character(s) to search for mentors: ");
        String str = sc.nextLine();

        List<String> mentors = searchMentors(str, mentorMenteeData);

        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

        if (!mentors.isEmpty()) {
            System.out.println("Mentors with mentee containing '" + str + "' in their email:");
            System.out.println();
            for (String mentor : mentors) {
                Matcher matcher = emailPattern.matcher(mentor);
                System.out.println(mentor);
                if(matcher.matches() && mentor.toLowerCase().trim().contains("clarivate.com")) {
                    System.out.println("Email status : Valid Email");
                    System.out.println();
                }else{
                    System.out.println("Email status : Invalid Email");
                }
            }
        }
        else {
            System.out.println("No mentors found for the given mentee character(s).");
        }
    }
    static List<String[]> readCSVFile(String filePath) {
        List<String[]> mentorMenteeData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] mentorMenteePair = line.split(",");
                mentorMenteeData.add(mentorMenteePair);
            }
        } catch (IOException e) {
            System.out.println("Exception caught");
        }
        return mentorMenteeData;
    }
    static List<String> searchMentors(String menteeChar, List<String[]> mentorMenteeData) {
        List<String> mentors = new ArrayList<>();

        for (String[] mentorMenteePair : mentorMenteeData) {
            String menteeEmail = mentorMenteePair[0].trim();
            String mentorEmail = mentorMenteePair[1].trim();

            if (menteeEmail.toLowerCase().trim().contains(menteeChar.toLowerCase().trim())) {
                mentors.add(mentorEmail);
            }
        }
        return mentors;
    }
}
