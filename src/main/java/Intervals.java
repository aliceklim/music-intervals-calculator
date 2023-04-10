public class Intervals {

    private static final String[][] SEMITONES_AND_DEGREES_FOR_INTERVAL = {
            {"m2", "1", "2"}, {"M2", "2", "2"}, {"m3", "3", "3"}, {"M3", "4", "3"}, {"P4", "5", "4"},
            {"P5", "7", "5"}, {"m6", "8", "6"}, {"M6", "9", "6"}, {"m7", "10", "7"}, {"M7", "11", "7"}, {"P8", "12", "8"}
    };

    private static final String[] SEMITONE_SCALE = {"C", "_", "_", "D", "_", "_", "E", "_", "F", "_", "_", "G", "_",
            "_", "A", "_", "_", "B", "_"};

    private static final String[] NOTES = {"C", "D", "E", "F", "G", "A", "B"};

    private static final String[] ACCIDENTALS = {"##", "#", "b", "bb"};

    private static final String[] ALLOWEDNOTES = {"Cb", "C", "C#", "Db", "D", "D#", "Eb", "E", "E#", "Fb", "F", "F#",
            "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B", "B#"};


    public static String intervalConstruction(String[] args) {
        String firstNote = args[1];
        Order order = args.length == 3 ? validateOrder(args[2].toUpperCase()) : Order.ASC;
        String[] semitoneAndDegree = getInterval(args[0], 0);

        int semitone = Integer.parseInt(semitoneAndDegree[1]);
        int degree = Integer.parseInt(semitoneAndDegree[2]);

        if (isNoteAllowed(firstNote)){
            return getSecondNote(firstNote, semitone, degree, order);
        }
        return "Input note is not allowed";
    }

    public static String intervalIdentification(String[] args) {
        String firstNote = args[0];
        String lastNote = args[1];
        Order order = args.length == 3 ? validateOrder(args[2].toUpperCase()) : Order.ASC;
        String[] interval = findInterval(firstNote, lastNote, order);
        return interval[0];
    }

    private static int countSemitones(String firstNote, String lastNote, Order order){
        int firstNoteAccidental = checkAccidental(firstNote);
        int secondNoteAccidental = checkAccidental(lastNote);
        int firstNoteIndex = getNoteIndex(firstNote, SEMITONE_SCALE);
        int lastNoteIndex = getNoteIndex(lastNote, SEMITONE_SCALE);
        return order == Order.ASC ?
                countSemitoneAsc(firstNoteIndex, lastNoteIndex, firstNoteAccidental, secondNoteAccidental) :
                countSemitoneDesc(firstNoteIndex, lastNoteIndex, firstNoteAccidental, secondNoteAccidental);
    }

    private static int countSemitoneAsc(int firstNoteIndex, int lastNoteIndex,
                                        int firstNoteAccidental, int secondNoteAccidental){
        int actualSemitone = 0;
        for (int i = firstNoteIndex; i <= SEMITONE_SCALE.length; i++) {
            if (SEMITONE_SCALE[i].equals("_")) {
                actualSemitone++;
            }
            if (i == lastNoteIndex){
                return actualSemitone - firstNoteAccidental - secondNoteAccidental;
            }
            if (i == SEMITONE_SCALE.length - 1) {
                i = 0;
                continue;
            }
        }
        return actualSemitone;
    }

    private static int countSemitoneDesc(int firstNoteIndex, int lastNoteIndex,
                                         int firstNoteAccidental, int secondNoteAccidental){
        int actualSemitone = 0;

        for (int i = firstNoteIndex; i >= 0; i--) {
            if (SEMITONE_SCALE[i].equals("_")) {
                actualSemitone++;
            }
            if (i == lastNoteIndex){
                return actualSemitone - firstNoteAccidental + secondNoteAccidental;
            }
            if (i <= 0) {
                i = SEMITONE_SCALE.length;
                continue;
            }
        }
        return actualSemitone;
    }

    private static String[] findInterval(String firstNote, String lastNote, Order order){
        int semitone = countSemitones(firstNote, lastNote, order);
        if (semitone < 0 ){
            semitone = 1;
        }
        return getInterval(Integer.toString(semitone), 1);
    }

    private static String getSecondNoteAsc(int firstNoteIndex, String lastNote, int intervalSemitone, String firstNote) {
        int actualSemitone = 0;
        int difference = 0;
        for (int i = firstNoteIndex; i < SEMITONE_SCALE.length; i++) {
            if (SEMITONE_SCALE[i].equals("_")) {
                actualSemitone++;
            }
            if (SEMITONE_SCALE[i].equals(lastNote)){
                difference = intervalSemitone - (actualSemitone + checkAccidental(firstNote));
                return addAccidental(SEMITONE_SCALE[i], difference);
            }
            if (i == SEMITONE_SCALE.length - 1) {
                i = 0;
                continue;
            }
        }
        return "not found";
    }

    private static String getSecondNoteDsc(int firstNoteIndex, String lastNote, int intervalSemitone, String firstNote) {
        int actualSemitone = 0;
        int difference = 0;
        for (int i = firstNoteIndex; i >= 0; i--) {
            if (SEMITONE_SCALE[i].equals("_")) {
                actualSemitone++;
            }
            if (SEMITONE_SCALE[i].equals(lastNote)){
                difference = actualSemitone - checkAccidental(firstNote) - intervalSemitone;
                return addAccidental(SEMITONE_SCALE[i], difference);
            }
            if (i <= 0) {
                i = SEMITONE_SCALE.length;
                continue;
            }
        }
        return "not found";
    }

    /**
     * Checks if the note has an accidental and what kind of accidental is it
     */
    private static int checkAccidental(String firstNote) {
        switch (firstNote.length()) {
            case 1:
                return 0;
            case 2:
                char c = firstNote.charAt(1);
                switch (c) {
                    case 'b':
                        return 1;
                    case '#':
                        return -1;
                    default:
                        throw new IllegalArgumentException();
                }
            case 3:
                char d = firstNote.charAt(2);
                switch (d) {
                    case 'b':
                        return 2;
                    case '#':
                        return -2;
                }

            default:
                throw new IllegalArgumentException("Wrong accidental type. Only 'b', '#' allowed.");
        }
    }

    /**
     * Ads accidental to the note
     */
    private static String addAccidental(String note, int difference){
        return switch (difference){
            case -2 -> note + ACCIDENTALS[3];
            case -1 -> note + ACCIDENTALS[2];
            case 0 -> note;
            case 1 -> note + ACCIDENTALS[1];
            case 2 -> note + ACCIDENTALS[0];
            default -> throw new IllegalStateException("Interval does not exist");
        };
    }

    /**
     * Counts the degree and semitones. Returns the last note for the chosen interval
     */
    private static String getSecondNote(String firstNote, int intervalSemitone, int degree, Order order){
        int firstNoteIndex = getNoteIndex(firstNote, SEMITONE_SCALE);
        String lastNote = getNoteByDegree(degree, order, firstNote);

        if (order.equals(Order.ASC)){
            return getSecondNoteAsc(firstNoteIndex, lastNote, intervalSemitone, firstNote);
        } else {
            return getSecondNoteDsc(firstNoteIndex, lastNote, intervalSemitone, firstNote);
        }
    }

    /**
     * Returns the index of the note in the array
     */
    private static int getNoteIndex(String note, String[] arr){
        int index = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i].equals(Character.toString(note.charAt(0)))) {
                index = i;
                break;
            }
            i++;
        }
        return index;
    }

    /**
     * Get semitone and note degree by interval name
     */
    private static String[] getInterval(String param, int position){
        for (String[] subArray : SEMITONES_AND_DEGREES_FOR_INTERVAL) {
            if (subArray[position].equals(param)){
                return subArray;
            }
        }
        throw new IllegalArgumentException("!!!!");
    }

    enum Order {
        ASC, DSC
    }

    /**
     * Checks whether the passed order type is valid
     */
    private static Order validateOrder(String order){
        if (order.equals(Order.ASC.toString()) || order.equals(Order.DSC.toString())){
            return order.equals(Order.ASC.toString()) ? Order.ASC : Order.DSC;
        } else {
            throw new IllegalArgumentException("You've indicated a wrong order type. Only 'asc' or 'dsc' accepted");
        }
    }

    /**
     * Counts the degree of the last note
     */
    private static String getNoteByDegree(int degree, Order order, String firstNote){
        int startIndex = getNoteIndex(firstNote, NOTES);
        if (order == Order.ASC) {
            int index = (startIndex + degree - 1) % NOTES.length;
            return NOTES[index];
        } else {
            int index = (startIndex - degree + 1) % NOTES.length;
            if (index < 0) {
                index += NOTES.length;
            }
            return NOTES[index];
        }
    }

    /**
     * Check if the note is allowed in input
     */
    private static boolean isNoteAllowed(String note) {
        for (String allowedNote : ALLOWEDNOTES) {
            if (allowedNote.equals(note)) {
                return true;
            }
        }
        return false;
    }
}


