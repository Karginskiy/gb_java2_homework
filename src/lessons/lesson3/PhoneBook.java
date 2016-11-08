package lessons.lesson3;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    private Map<String, ArrayList<PhoneRecord>> map;

    public PhoneBook() {
        this.map = new TreeMap<>();
    }

    public void addRecord(String name, String phone, String email) {
        ArrayList<PhoneRecord> phoneRecords = map.get(name);
        if (phoneRecords != null) {
            phoneRecords.add(new PhoneRecord(phone, email));
        } else {
            phoneRecords = new ArrayList<>();
            phoneRecords.add(new PhoneRecord(phone, email));
            this.map.put(name, phoneRecords);
        }
    }

    public ArrayList<PhoneRecord> getRecordsByName(String name) {
        return map.get(name);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
                String.format("PhoneBook with %d name%s. \n",
                map.size(),
                (map.size() == 1) ? "" : "s"));
        builder.append("  Sorted alphabetically. \n\n");
        for (Map.Entry<String, ArrayList<PhoneRecord>> entry : map.entrySet()) {
            builder.append(
                    String.format("  %s has %d record%s: \n",
                    entry.getKey(),
                    entry.getValue().size(),
                    (entry.getValue().size() == 1) ? "" : "s"));
            for (PhoneRecord record : entry.getValue()) {
                builder.append("\t");
                builder.append(record);
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
