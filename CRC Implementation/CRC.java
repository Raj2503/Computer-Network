import java.util.Arrays;

public class CRC {

    char[] div = new char[10];
    char[] divi1 = new char[10];

    int divilen, meslen, i, j;
    char[] mes = new char[20];
    char[] mestemp = new char[20];
    char[] quot = new char[20];
    char[] crc = new char[20];

    public void setDiv(char[] d) {
        div = d;
        // for(int i = 0; i<d.length; i++)
        // {  
        //     div[i] = d[i];
        // }
    }

    public void setMes(char[] m) {
        // for(int i = 0; i<m.length; i++)
        // {  
        //     mes[i] = m[i];
        // }
    }

    public void Encode() {
        divilen = div.length;
        System.out.print(div[5]);
        meslen = mes.length;
        System.out.println("Divisor: " + Arrays.toString(div));
        System.out.println("Divisor Length" + divilen);
        System.out.println("Message: " + Arrays.toString(mes));
        System.out.println("Message Length" + meslen);

        for (i = meslen; i < meslen + divilen - 1; i++) {
            mes[i] = '0';
        }

        divi1 = Arrays.copyOf(divi1, div.length);

        System.out.print(mes);

        mestemp = Arrays.copyOf(mes, mes.length);

        for (i = 0; i < meslen; i++) {
            quot[i] = mestemp[0];

            // MSB is 0?
            if (quot[i] == '0')
                // then XOR with 0s
                for (j = 0; j < divilen; j++)
                    // hence divisor all 0s
                    div[j] = '0';
            else
                for (j = 0; j < divilen; j++)
                    div[j] = divi1[j];

            // XOR individual bits to find CRC
            // traverse from LSB to MSB
            for (j = divilen - 1; j > 0; j--) {
                if (mestemp[j] == div[j])
                    crc[j - 1] = '0';
                else
                    crc[j - 1] = '1';
            }

            // carry next bit from message
            crc[divilen - 1] = mes[i + divilen];

            // Copy new remainder back
            // strcpy(mestemp, crc);
            mestemp = Arrays.copyOf(crc, crc.length);
        }
        mestemp = Arrays.copyOf(crc, crc.length);

        System.out.print("\nCRC: ");
        for (i = 0; i < divilen; i++) {
            System.out.print(crc[i]);
        }

    }

}
