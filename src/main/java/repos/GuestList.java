package repos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.Config;
import entities.Guest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuestList {

    public List<Guest> list;
    private final Gson gson;

    public GuestList() {
        this.gson = new Gson();
        this.list = load();
    }

    /**
     * Used for adding users to the list
     *
     * @param guest Guest to be added to the list
     */
    public void add(Guest guest) {
        list.add(guest);
    }

    /**
     * Saves the current list of guests to file configured in the config file
     */
    public void save() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Config.guestSaveFile));
            writer.write(gson.toJson(list));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the current list of guests if there is one and creates a new one if there isn't
     *
     * @return new or loaded ArrayList of guests
     */
    public List<Guest> load() {
        StringBuilder sb = new StringBuilder();
        boolean saveFileExists = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(Config.guestSaveFile));
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
                saveFileExists = true;
            }

            if (saveFileExists) {
                return gson.fromJson(sb.toString(), new TypeToken<List<Guest>>() {
                }.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "GuestList{" + System.lineSeparator() +
                "Firstname" + '\t' + "Lastname" + '\t' + "Paid" + System.lineSeparator() +
                list + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestList guestList = (GuestList) o;
        return Objects.equals(list, guestList.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
