package main.flowstoneenergy.core.utils;

import java.util.TreeMap;

public class ConnectedTextureIDGenerator {
    
private static TreeMap<String, Integer> textureMap = new TreeMap<String, Integer>();
        private static TreeMap<String, Integer> textureIDMapping = new TreeMap<String, Integer>();
        private static int[] textureIDs = new int[256];
    // MODIFY THE BELOW TEXTURE MAP CODE AND RUN THIS PROGRAM TO GENERATE
    // THE TEXTUREIDS ARRAY FOR USE IN CONNECTEDTEXTUREHELPER
    public static void main(String[] args) {
        
        /*
         * To make this work, all you need to do is change texture_map over to
         * your textures. Each entry takes a string of numbers indicating which
         * parts of the texture are filled in and an integer which is the
         * texture id. The part of the string are detailed below. For example,
         * if we wanted a texture with the full left side and a corner piece in
         * the upper-right, we would do texture_map.put( "25", id ) where id is
         * the texture id. 2 represents the left side and 5 represents the upper
         * right corner as detailed below. Do this for all 47 textures and the
         * program will output every block configuration along with the texture
         * id of the center block given your inputs.
         */
        // 0 = up
        // 1 = down
        // 2 = left
        // 3 = right
        // 4 = upper left
        // 5 = upper right
        // 6 = lower left
        // 7 = lower right

        textureMap.put("0123", 0);
        textureMap.put("012", 1);
        textureMap.put("01", 2);
        textureMap.put("013", 3);
        textureMap.put("027", 4);
        textureMap.put("036", 5);
        textureMap.put("257", 6);
        textureMap.put("067", 7);
        textureMap.put("467", 8);
        textureMap.put("546", 9);
        textureMap.put("57", 10);
        textureMap.put("67", 11);
        textureMap.put("023", 12);
        textureMap.put("02", 13);
        textureMap.put("0", 14);
        textureMap.put("03", 15);
        textureMap.put("215", 16);
        textureMap.put("314", 17);
        textureMap.put("145", 18);
        textureMap.put("436", 19);
        textureMap.put("576", 20);
        textureMap.put("457", 21);
        textureMap.put("45", 22);
        textureMap.put("46", 23);
        textureMap.put("23", 24);
        textureMap.put("2", 25);
        textureMap.put("", 26);
        textureMap.put("3", 27);
        textureMap.put("25", 28);
        textureMap.put("07", 29);
        textureMap.put("27", 30);
        textureMap.put("06", 31);
        textureMap.put("7", 32);
        textureMap.put("6", 33);
        textureMap.put("47", 34);
        textureMap.put("56", 35);
        textureMap.put("213", 36);
        textureMap.put("21", 37);
        textureMap.put("1", 38);
        textureMap.put("13", 39);
        textureMap.put("41", 40);
        textureMap.put("63", 41);
        textureMap.put("51", 42);
        textureMap.put("43", 43);
        textureMap.put("5", 44);
        textureMap.put("4", 45);
        textureMap.put("4675", 46);

        for( int x = 0; x < textureIDs.length; x++ )
        {
            textureIDs[x] = -1;
        }
        
        for (String s : textureMap.keySet()) {
            StringBuffer binary = new StringBuffer("00000000");

            for (int x = 0; x < s.length(); x++) {
                int index = Integer.parseInt("" + s.charAt(x));
                binary.setCharAt(index, '1');
            }

            textureIDMapping.put(new String(binary), textureMap.get(s));
        }

        for (int x = 0; x < 256; x++) {
            String binary_string = Integer.toBinaryString(x);

            while (binary_string.length() < 8) {
                binary_string = "0" + binary_string;
            }

            boolean[] digits = new boolean[8];

            for (int y = 0; y < 8; y++) {
                digits[y] = (binary_string.charAt(y) == '1');
            }
            
            process( digits );
        }
        
        for( int id : textureIDs )
        {
            if( id < 0 )
            {
                System.out.println( "!!!ERROR!!! INVALID TEXTURE CONFIGURATIONS; CHECK FOR NULL TEXTURES" );
                break;
            }
        }
        
        String output = "int[] array = {";
        
        for( int id : textureIDs )
        {
            output += id + ", ";
        }
        
        output = output.substring( 0, output.length() - 2 );
        output += "};";
        
        System.out.println( output );
    }

    private static void process(boolean[] digits) {
        // digits represent the blocks being there or being absent
        // textures represent each side/corner being there or being absent

        StringBuffer texture_configuration = new StringBuffer("00000000");

        if (!digits[1]) {
            texture_configuration.setCharAt(0, '1');
        }

        if (!digits[6]) {
            texture_configuration.setCharAt(1, '1');
        }

        if (!digits[3]) {
            texture_configuration.setCharAt(2, '1');
        }

        if (!digits[4]) {
            texture_configuration.setCharAt(3, '1');
        }

        if (digits[1] && digits[3] && !digits[0]) {
            texture_configuration.setCharAt(4, '1');
            texture_configuration.setCharAt(2, '0');
            texture_configuration.setCharAt(0, '0');
        }

        if (digits[1] && digits[4] && !digits[2]) {
            texture_configuration.setCharAt(5, '1');
            texture_configuration.setCharAt(0, '0');
            texture_configuration.setCharAt(3, '0');
        }

        if (digits[3] && digits[6] && !digits[5]) {
            texture_configuration.setCharAt(6, '1');
            texture_configuration.setCharAt(1, '0');
            texture_configuration.setCharAt(2, '0');
        }

        if (digits[4] && digits[6] && !digits[7]) {
            texture_configuration.setCharAt(7, '1');
            texture_configuration.setCharAt(1, '0');
            texture_configuration.setCharAt(3, '0');
        }

        if (texture_configuration.charAt(0) == '1' || texture_configuration.charAt(2) == '1') {
            texture_configuration.setCharAt(4, '0');
        }

        if (texture_configuration.charAt(0) == '1' || texture_configuration.charAt(3) == '1') {
            texture_configuration.setCharAt(5, '0');
        }

        if (texture_configuration.charAt(1) == '1' || texture_configuration.charAt(3) == '1') {
            texture_configuration.setCharAt(7, '0');
        }

        if (texture_configuration.charAt(1) == '1' || texture_configuration.charAt(2) == '1') {
            texture_configuration.setCharAt(6, '0');
        }

        displayBlockConfiguration(digits, texture_configuration);
    }

    private static void displayBlockConfiguration(boolean[] digits, StringBuffer texture_configuration) {
        Integer texture_id = textureIDMapping.get(new String(texture_configuration));

        System.out.println("=====");

        for (int x = 0; x <= 2; x++) {
            if (digits[x]) {
                System.out.print("X");
            } else {
                System.out.print(" ");
            }
        }

        System.out.println();

        if (digits[3]) {
            System.out.print("X");
        } else {
            System.out.print(" ");
        }

        System.out.print("Y");

        if (digits[4]) {
            System.out.print("X");
        } else {
            System.out.print(" ");
        }

        String texture_output = "";

        for (int x = 0; x < 8; x++) {
            char c = texture_configuration.charAt(x);

            if (c == '1') {
                switch (x) {
                    case 0:
                        texture_output += "up, ";
                        break;
                    case 1:
                        texture_output += "down, ";
                        break;
                    case 2:
                        texture_output += "left, ";
                        break;
                    case 3:
                        texture_output += "right, ";
                        break;
                    case 4:
                        texture_output += "upper-left, ";
                        break;
                    case 5:
                        texture_output += "upper-right, ";
                        break;
                    case 6:
                        texture_output += "lower-left, ";
                        break;
                    case 7:
                        texture_output += "lower-right, ";
                        break;
                }
            }
        }

        if (texture_output.length() > 2) {
            texture_output = texture_output.substring(0, texture_output.length() - 2);
        }

        System.out.println(" = " + texture_id + " (" + texture_output + ")");

        textureIDs[binaryDigitsArrayToDecimal( digits )] = texture_id;
        
        for (int x = 5; x <= 7; x++) {
            if (digits[x]) {
                System.out.print("X");
            } else {
                System.out.print(" ");
            }
        }

        System.out.println("\n=====");
    }

    public static int binaryDigitsArrayToDecimal( boolean[] digits )
    {
        int value = 0;
        String valueString = "";
        
        for( boolean b : digits )
        {
            valueString += (b)?("1"):("0");
        }
        
        value = Integer.parseInt( valueString, 2 );
        
        return value;
    }
}
