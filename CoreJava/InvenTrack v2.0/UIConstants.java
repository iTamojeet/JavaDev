/**
 * UI Constants for InvenTrack v2.0
 * Contains ANSI color codes and formatting constants for enhanced console UI
 */
public class UIConstants {
    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Background Colors
    public static final String BLACK_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String BLUE_BG = "\u001B[44m";
    public static final String PURPLE_BG = "\u001B[45m";
    public static final String CYAN_BG = "\u001B[46m";
    public static final String WHITE_BG = "\u001B[47m";

    // Text Formatting
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String ITALIC = "\u001B[3m";

    // UI Elements
    public static final String HEADER_BORDER = "╔════════════════════════════════════════════════════════════════════════════════════════════════╗";
    public static final String FOOTER_BORDER = "╚════════════════════════════════════════════════════════════════════════════════════════════════╝";
    public static final String TABLE_BORDER = "═══════════════════════════════════════════════════════════════════════════════════════════════════";
    public static final String SEPARATOR = "─────────────────────────────────────────────────────────────────────────────────────────────────────";

    // Icons
    public static final String SUCCESS_ICON = "✅";
    public static final String ERROR_ICON = "❌";
    public static final String WARNING_ICON = "⚠️";
    public static final String INFO_ICON = "ℹ️";
    public static final String ARROW_RIGHT = "➤";
    public static final String BULLET_POINT = "•";

    /**
     * Print colored text
     */
    public static void printColored(String text, String color) {
        System.out.print(color + text + RESET);
    }

    /**
     * Print colored line
     */
    public static void printColoredLine(String text, String color) {
        System.out.println(color + text + RESET);
    }

    /**
     * Print success message
     */
    public static void printSuccess(String message) {
        System.out.println(GREEN + SUCCESS_ICON + " " + message + RESET);
    }

    /**
     * Print error message
     */
    public static void printError(String message) {
        System.out.println(RED + ERROR_ICON + " " + message + RESET);
    }

    /**
     * Print warning message
     */
    public static void printWarning(String message) {
        System.out.println(YELLOW + WARNING_ICON + " " + message + RESET);
    }

    /**
     * Print info message
     */
    public static void printInfo(String message) {
        System.out.println(CYAN + INFO_ICON + " " + message + RESET);
    }

    /**
     * Print a decorative header
     */
    public static void printHeader(String title) {
        System.out.println(CYAN + HEADER_BORDER + RESET);
        String padding = " ".repeat((100 - title.length()) / 2);
        System.out.println(CYAN + "║" + padding + BOLD + WHITE + title + RESET + CYAN + padding + "║" + RESET);
        System.out.println(CYAN + FOOTER_BORDER + RESET);
    }

    /**
     * Print a section separator
     */
    public static void printSeparator() {
        System.out.println(CYAN + SEPARATOR + RESET);
    }

    /**
     * Clear screen (works on most terminals)
     */
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[2J\033[H");
            }
        } catch (Exception e) {
            // Fallback: print multiple newlines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    /**
     * Wait for user input
     */
    public static void waitForEnter() {
        System.out.print(YELLOW + "\nPress Enter to continue..." + RESET);
        try {
            System.in.read();
        } catch (Exception e) {
            // Ignore
        }
    }
}