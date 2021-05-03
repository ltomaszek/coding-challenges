package com.ltcode.solutions;

public class _1700_NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int sandwichIdx = 0;
        int studentsOut = 0; // students who already have a sandwich

        while (sandwichIdx < sandwiches.length) {
            boolean anyChanges = false;

            for (int studentIdx = 0; studentIdx < students.length; studentIdx++) {
                if (students[studentIdx] == sandwiches[sandwichIdx]) {
                    sandwichIdx++;
                    if (sandwichIdx == sandwiches.length)
                        return 0;
                    studentsOut++;
                    students[studentIdx] = -1;
                    anyChanges = true;
                }
            }

            if (anyChanges == false)
                break;
        }

        return students.length - studentsOut;
    }
}
