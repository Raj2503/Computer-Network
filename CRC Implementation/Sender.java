import java.util.Scanner;

public class Sender {
    public static void main(String[] args) {
        CRC crc = new CRC();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the message: ");
        String message = in.nextLine();
        System.out.println("Enter the divisior: ");
        String seed = in.nextLine();

        
        crc.setDiv(seed.toCharArray());
        crc.setMes(message.toCharArray());

        crc.Encode();
        in.close();
    }

}