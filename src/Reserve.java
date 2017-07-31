import java.util.HashMap;
import java.util.Map;

public class Reserve {

    private String reserve_order;
    private int total_seats_number;
    private int seats_start_number;
    private int row;

    private Map<String, int[]> seatMap = new HashMap<String, int[]>();


    public Map getSeatMap() {
        return seatMap;
    }

    public void setSeatMap(Map seatMap) {
        this.seatMap = seatMap;
    }

    public Reserve(String reserve_order, int total_seats_number, int seats_start_number, int row) {
        this.reserve_order = reserve_order;
        this.total_seats_number = total_seats_number;
        this.seats_start_number = seats_start_number;
        this.row = row;
    }

    public int getTotal_seats_number() {
        return total_seats_number;
    }


    /**
     * Format the Reservation and return the string
     * @return The completed line of the reservation
     */
    public String printReserve() {
        StringBuilder sb = new StringBuilder();
        sb.append(reserve_order);
        sb.append(" ");

        for (String key : seatMap.keySet()) {
            char row_letter = getRowLetter(Integer.parseInt(key));
            if (row_letter == 'N'){
                sb.append("No available seats");
            }else{
                for (int i = 0; i < total_seats_number; i++){
                    if (i != total_seats_number -1){
                        sb.append(row_letter);
                        sb.append(seatMap.get(key)[i]);
                        sb.append(", ");
                    }else{
                        sb.append(row_letter);
                        sb.append(seatMap.get(key)[i]);
                    }

                }
            }
        }

        return sb.toString();
    }

    /**
     * Return the row letter according to the row
     * @param row
     * @return
     */
    public char getRowLetter(int row) {

        switch (row) {
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'D';
            case 5:
                return 'E';
            case 6:
                return 'F';
            case 7:
                return 'G';
            case 8:
                return 'H';
            case 9:
                return 'I';
            case 10:
                return 'J';

        }
        return 'N';
    }

    public void setTotal_seats_number(int total_seats_number) {
        this.total_seats_number = total_seats_number;
    }
}
