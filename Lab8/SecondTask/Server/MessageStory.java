import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

public class MessageStory {
    private LinkedList<String> messageStory = new LinkedList<>();

    public void addStoryElement(String message) {
        if (messageStory.size() >= 10) {
            messageStory.removeFirst();
        }
        messageStory.add(message);
    }

    public void printStory(BufferedWriter writer) {
        if (messageStory.size() > 0) {
            try {
                writer.write("History messages" + "\n");
                for (String vr : messageStory) {
                    writer.write(vr + "\n");
                }
                writer.write("/...." + "\n");
                writer.flush();
            } catch (IOException ignored) { }
        }
    }
}