public class Vending {
    public static void main(String[] args) {
        level5();
    }

    private static void level5() {
        String[] inputs = "X24 H17 V4\nP15 I9 D7".split("\n");
        for (String input : inputs) {
            String[] command = input.split(" ");
            String maxSizeString = command[0];
            String startString = command[1];
            String endString = command[2];
            int maxRow = getRow(maxSizeString.charAt(0)), maxCol = Integer.parseInt(maxSizeString.substring(1));
            int startRow = getRow(startString.charAt(0)), startCol = Integer.parseInt(startString.substring(1));
            int endRow = getRow(endString.charAt(0)), endCol = Integer.parseInt(endString.substring(1));
            int count = 0;
            System.out.println("Start: " + startString + ", End: " + endString);
            while (true) {
                if (startRow < endRow) {
                    if (startCol < endCol) {
                        startCol += 1;
                    } else {
                        startCol -= 1;
                    }
                    startRow += 1;
                    count++;
                } else if (startRow > endRow) {
                    if (startCol < endCol) {
                        startCol += 1;
                    } else {
                        startCol -= 1;
                    }
                    startRow -= 1;
                    count++;
                } else if (startRow == endRow) {
                    int move = startCol - endCol;
                    if (move < 0) {
                        move *= (-1);
                    }
                    startCol = endCol;
                    count += move;
                    break;
                } else if (startCol == endCol) {
                    int move = startRow - endRow;
                    if (move < 0) {
                        move *= (-1);
                    }
                    startRow = endRow;
                    count += move;
                    break;
                }
                System.out.println("Now: " + ((char) (startRow+64)) + startCol );
            }
            System.out.println(count);
        }
    }

    private static void level4() {
        String[] values = "H9 375 470 30 810 784 227 249 94 662 104 153 389 989 659 257 609 40 463 844 60 263 588 764 623 521 780 624 415 899 425 389 22 746 378 151 188 124 836 613 91 458 575 373 933 788 201 948 471 468 641 592 259 808 248 992 608 517 540 589 288 592 171 336 225 842 157 988 196 702 460 212 268 1 2 5 9 2 6 4 3 3 6 6 8 4 3 4 3 4 1 1 7 4 9 9 2 9 2 4 2 2 5 9 9 7 9 9 4 3 3 3 3 6 8 2 5 2 5 7 2 2 1 7 5 9 1 8 3 9 7 4 1 4 3 8 6 9 9 1 3 8 9 7 6 37 G8 F6 H9 B4 D5 F6 E5 B6 E6 A4 E2 D8 G9 A8 G3 E9 A2 H2 D9 B1 C2 E6 A7 G9 H2 G2 A5 H2 E1 C6 G3 B8 E7 A1 H3 C9 H2\nG24 993 213 656 340 991 318 369 598 320 688 684 156 231 843 928 662 159 68 455 628 792 888 567 512 838 344 502 217 277 796 776 653 332 870 547 134 118 119 81 267 51 151 612 457 748 410 220 193 547 20 128 684 166 957 73 958 822 827 124 772 428 622 72 373 477 431 716 356 120 434 382 785 434 756 968 593 598 675 512 252 253 722 164 281 670 303 495 524 804 612 207 605 221 857 137 880 550 615 931 423 501 767 470 942 295 463 817 964 296 398 696 716 333 379 540 13 544 776 856 361 463 567 978 42 589 257 507 80 200 15 508 866 396 555 413 287 504 381 665 875 489 851 948 432 324 625 734 341 266 310 415 432 452 204 224 443 531 121 974 938 442 432 87 740 467 911 257 232 9 1 1 7 5 6 6 9 8 5 8 8 1 2 5 6 7 4 8 6 3 6 2 9 7 4 2 5 2 4 8 5 4 1 1 5 3 5 4 7 6 2 7 3 9 1 5 2 4 2 3 5 4 6 5 9 1 6 5 4 2 8 2 9 1 2 8 2 9 7 6 3 3 9 9 8 9 3 2 9 3 1 7 3 4 4 6 4 1 3 8 3 7 7 1 4 7 1 9 2 4 6 1 9 4 7 5 9 4 4 8 1 2 8 7 6 8 6 6 7 2 4 3 5 1 6 7 8 5 2 8 6 1 1 6 4 8 2 1 3 3 7 1 1 4 7 1 2 4 9 1 3 7 6 9 9 4 2 8 9 8 1 4 8 2 6 3 6 15 E15 F7 E9 F17 B8 B1 B1 G21 C9 A5 D14 E10 D4 D4 B3\nK26 676 738 585 378 185 597 203 350 902 681 70 947 998 928 345 394 964 9 799 983 993 179 634 484 461 218 942 875 164 949 836 634 177 205 335 513 743 460 155 206 419 696 526 655 886 144 343 340 261 981 410 555 372 894 498 880 67 209 257 211 958 711 36 245 993 142 687 613 175 655 384 68 136 365 454 567 94 255 100 85 499 868 735 763 352 843 697 869 56 728 892 421 113 337 535 471 766 398 221 187 29 798 738 697 33 66 960 40 607 628 256 250 943 356 719 150 990 104 255 759 594 305 451 385 100 145 372 698 295 740 582 805 778 44 776 622 265 58 677 579 514 637 156 711 954 192 406 283 899 674 222 193 531 369 127 345 220 130 21 342 597 434 36 724 736 579 402 240 708 108 188 151 881 875 325 755 208 931 760 632 84 222 12 162 769 366 180 141 822 976 582 51 411 819 428 116 562 909 829 911 665 67 106 394 853 568 992 817 843 818 543 171 723 915 522 573 707 903 939 271 471 257 988 807 368 266 887 811 428 327 323 937 383 34 466 210 34 500 767 470 993 802 347 800 366 868 642 837 376 755 837 722 978 457 410 386 137 814 510 26 674 858 457 259 970 353 481 381 932 713 600 776 656 479 621 838 157 546 833 769 553 36 663 693 359 376 1 9 4 2 9 9 4 5 4 5 8 6 4 4 6 8 7 7 2 8 6 4 9 6 4 5 6 7 2 6 3 7 3 8 1 3 2 3 2 2 3 9 9 1 1 4 2 6 8 6 6 1 9 4 2 3 6 4 6 6 5 8 3 2 6 2 5 6 3 2 9 2 6 8 6 1 1 6 6 7 8 2 1 7 5 1 9 5 1 4 3 7 4 6 4 9 6 7 2 3 3 7 5 1 2 3 6 7 4 5 2 3 1 3 9 6 7 2 1 3 7 6 4 9 5 6 8 2 8 8 5 7 8 2 3 5 1 9 7 3 1 7 2 6 1 1 7 2 9 8 4 8 6 5 8 8 2 9 2 9 8 7 3 2 4 1 3 8 7 6 6 3 1 2 6 6 2 1 6 7 8 4 1 4 9 5 4 9 3 3 1 2 8 2 5 9 6 7 8 2 9 3 3 6 4 3 8 6 1 9 9 1 4 1 2 6 9 7 5 8 6 8 8 5 6 8 5 3 5 3 7 1 1 5 8 3 9 3 6 9 5 8 1 8 3 4 7 1 7 8 4 7 5 1 1 8 9 6 3 4 2 7 5 2 2 6 2 7 7 7 9 1 4 8 5 3 6 5 9 4 3 3 5 4 4 9 92 F16 F26 B2 A5 H13 G12 D18 C16 A25 K26 C7 B18 B14 A10 G24 J14 J10 B25 E2 B21 K1 B8 D21 F16 F5 D24 C14 J17 B5 I18 E2 H21 F14 H22 I3 G10 K9 E16 E8 B15 J10 F15 F2 B20 D24 K11 C2 H23 I17 E3 J16 A16 D12 C8 H11 F25 K17 C22 K19 A18 D14 K3 F18 A18 E25 C13 H1 G12 E21 G12 F10 K13 I7 C16 C2 K22 K1 D10 A19 J24 B10 G25 I14 D14 J14 B13 I18 E21 I4 D5 J19 G16".split("\n");
        for (String value : values) {
            String[] array = value.split(" ");
            String maxSnack = array[0];
            int rows = getRow(maxSnack.charAt(0)),
                    cols = Integer.parseInt(maxSnack.substring(1)),
                    count = 1;
            Snack[][] maschine = new Snack[rows][cols];
            //new Snack with Coordinate and Price
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    maschine[i][j] = new Snack(Integer.parseInt(array[count]));
                    count++;
                }
            }
            //stock for existing Snack
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    maschine[i][j].stock = Integer.parseInt(array[count]);
                    count++;
                }
            }
            int orderCount = Integer.parseInt(array[count]);
            count++;
            int sum = 0;
            for (int i = count; i < array.length; i++) {
                String order = array[i];
                int orderRow = getRow(order.charAt(0)),
                        orderCol = Integer.parseInt(order.substring(1));
                Snack tempSnack = maschine[orderRow - 1][orderCol - 1];
                if (tempSnack.stock != 0) {
                    sum += tempSnack.price;
                    tempSnack.stock -= 1;
                }
            }
            System.out.println(sum);
        }
    }

    private static void level3() {
        String[] values = ("O12 3577 4269 4082 3042 2126 2174 1828 1482 1238 2290 186 4243 4170 231 3374 3400 2886 4271 4487 3326 4770 663 1598 3190 3574 3820 1816 3305 4414 445 3620 2605 1015 2735 4052 4293 2313 3494 245 3343 4427 1511 1477 3676 1831 1359 1234 1067 3763 3655 3975 3864 1073 1524 564 3916 329 3929 1802 3476 4967 572 1315 3144 3913 4533 3146 2330 4124 2138 1861 2243 4345 2334 122 323 4653 3125 464 4243 4885 664 3347 30 3875 1772 1415 4810 4813 4443 4564 3355 543 4828 183 104 262 3776 207 2118 3585 2656 2345 232 1837 620 4163 1417 1929 3287 2409 3362 1558 2585 1263 1406 35 171 732 1559 3906 214 1637 996 988 2374 3115 4812 1593 1246 1945 757 885 491 915 4177 4612 457 771 563 2871 4097 740 4330 772 4150 138 1816 2541 3335 2048 930 2328 3763 3127 1379 2150 2542 277 4676 4773 4515 747 2989 77 3804 3599 2311 573 2732 4831 1329 2854 2708 379 1136 1020 3985 3038 2108 N3 46 20 5 50 200 10 1 200 1 5 10 50 2 10 10 10 20 2 20 5 2 20 2 200 1 5 5 20 2 1 100 1 20 200 200 1 200 200 10 50 50 10 20 20 5 1 10" + "\n").split("\n");
        for (String value : values) {
            String[] array = value.split(" ");
            String maxSnack = array[0];
            int rows = getRow(maxSnack.charAt(0)),
                    cols = Integer.parseInt(maxSnack.substring(1)),
                    count = 1;
            int[][] maschine = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    maschine[i][j] = Integer.parseInt(array[count]);
                    count++;
                }
            }
            String cost = array[count];
            int costRow = getRow(cost.charAt(0));
            int costCol = Integer.parseInt(cost.substring(1));
            int costs = maschine[costRow - 1][costCol - 1];
            count++;
            int amountOfCoins = Integer.parseInt(array[count]);
            count++;
            int sum = 0;
            for (int i = count; i < array.length; i++) {
                int val = Integer.parseInt(array[i]);
                sum += val;
            }
            if (isGoodInput(amountOfCoins, sum)) {
                String message;
                if (sum < costs) {
                    message = "MISSING " + (costs - sum);
                } else {
                    message = "CHANGE " + change(sum - costs);
                }
                System.out.println(message);
            }
        }
    }

    private static int getRow(char c) {
        return c - 64;
    }

    private static void level2() {
        String string = """
                99 5 50 20 20 20 20
                99 4 50 5 10 10
                984 5 200 200 100 2 2
                980 29 200 5 1 200 2 50 10 200 50 2 1 50 50 5 2 50 100 10 50 5 5 10 2 200 2 20 5 10 2
                812 13 2 200 1 20 2 100 50 1 100 20 2 5 2
                919 88 20 5 1 20 50 20 1 2 10 2 200 200 5 2 1 200 20 200 100 2 1 1 5 2 20 1 2 2 20 1 50 100 100 10 1 5 50 50 10 20 10 100 200 5 10 5 50 200 1 2 50 10 50 20 2 5 20 1 5 20 20 10 10 50 20 100 2 1 10 200 50 1 1 200 20 2 50 100 20 10 200 20 10 100 20 20 1 20""";
        String[] values = string.split("\n");
        for (String value : values) {
            String[] array = value.split(" ");
            int costs = Integer.parseInt(array[0]);
            int amountOfCoins = Integer.parseInt(array[1]);
            int sum = 0;
            for (int i = 2; i < array.length; i++) {
                int val = Integer.parseInt(array[i]);
                sum += val;
            }
            if (isGoodInput(amountOfCoins, sum)) {
                String message;
                if (sum < costs) {
                    message = "MISSING " + (costs - sum);
                } else {
                    message = "CHANGE " + change(sum - costs);
                }
                System.out.println(message);
            }
        }
    }

    private static String change(int change) {
        //Coins: 1, 2, 5, 10, 20, 50, 100, 200
        int oneCent = 0, twoCent = 0, fiveCent = 0, tenCent = 0, twentyCent = 0, fiftyCent = 0, oneEuro = 0, twoEuro = 0;
        int[] cents = {200, 100, 50, 20, 10, 5, 2, 1};
        for (int cent : cents) {
            while (true) {
                if ((change - cent) >= 0) {
                    change -= cent;
                    switch (cent) {
                        case 200 -> twoEuro++;
                        case 100 -> oneEuro++;
                        case 50 -> fiftyCent++;
                        case 20 -> twentyCent++;
                        case 10 -> tenCent++;
                        case 5 -> fiveCent++;
                        case 2 -> twoCent++;
                        default -> oneCent++;
                    }
                } else {
                    break;
                }
            }
        }
        return oneCent + " " + twoCent + " " + fiveCent + " " + tenCent + " " + twentyCent + " " + fiftyCent + " " + oneEuro + " " + twoEuro;
    }

    private static void level1() {
        String string = "99 4 50 20 20 20\n99 4 50 5 10 10\n1091 26 5 20 200 2 5 1 10 20 100 10 20 100 10 10 50 10 5 200 1 2 20 20 1 100 50 50\n781 15 5 2 5 10 200 2 1 1 50 20 5 10 10 1 5\n273 13 5 1 20 2 10 10 20 10 10 50 200 2 5";
        String[] values = string.split("\n");
        for (String value : values) {
            String[] array = value.split(" ");
            int costs = Integer.parseInt(array[0]);
            int amountOfCoins = Integer.parseInt(array[1]);
            int sum = 0;
            for (int i = 2; i < array.length; i++) {
                int val = Integer.parseInt(array[i]);
                sum += val;
            }
            if (isGoodInput(amountOfCoins, sum)) {
                String message;
                if (sum < costs) {
                    message = "MISSING " + (costs - sum);
                } else {
                    message = "CHANGE " + (sum - costs);
                }
                System.out.println(message);
            }
        }
    }

    private static boolean isGoodInput(int amountOfCoins, int sum) {
        return amountOfCoins <= 5000 && amountOfCoins >= 1 && sum <= 10000 && sum > 0;
    }
}

class Snack {
    public int price;
    public int stock;

    public Snack(int price) {
        this.price = price;
    }
}