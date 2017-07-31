import java.util.ArrayList;
import java.util.Arrays;

public class Theater {

    static final int seat_length = 20;
    static final int TOTAL_ROW = 10;

    int[] seatsArray = new int[10];


    /**
     * Initialize the array that indicates all the available seats
     *
     */

    public void arrayInitial() {
        for (int i = 0; i < this.seatsArray.length; i++) {
            this.seatsArray[i] = seat_length;
        }
    }

    /**
     * Assign seats to each reservation
     *
     * @param r          - The reservation for assigning seats
     */
    public void setSeats(Reserve r) {

        boolean assigned = false;

        for (int i = 0; i < this.seatsArray.length; i++) {
            if (this.seatsArray[i] >= r.getTotal_seats_number()) {

                int[] temp = new int[seat_length];
                int start = seat_length - this.seatsArray[i] + 1;
                for (int j = 0; j < r.getTotal_seats_number(); j++){
                    temp[j] = start;
                    start++;
                }

                int row_number = i + 5;
                if (row_number > TOTAL_ROW) {
                    row_number = 5 - (row_number - TOTAL_ROW);
                }
                this.seatsArray[i] -= r.getTotal_seats_number();
                r.getSeatMap().put(Integer.toString(row_number), temp);

                assigned = true;
                break;
            }
        }

        // For the ones you don't have enough to assign together.
//        if (!assigned){
//
//            int seats_need = r.getTotal_seats_number();
//
//            for (int i = 0; i < this.seatsArray.length; i++){
//                if (this.seatsArray[i] > 0){
//                    int[] temp = new int[seat_length];
//                    int start = seat_length - this.seatsArray[i] + 1;
//                    for (int j = 0; j < this.seatsArray[i]; j++){
//                        temp[j] = start;
//                        start++;
//                    }
//                    int row_number = i+5;
//                    if (row_number > TOTAL_ROW) {
//                        row_number = 5 - (row_number - TOTAL_ROW);
//                    }
//                    seats_need -= this.seatsArray[i];
//                    this.seatsArray[i] -=
//                }
//            }
//        }


    }

}
