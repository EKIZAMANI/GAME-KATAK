import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Tugas1 {

    static Scanner in = new Scanner(System.in);
    static Random randNum = new Random();
    static Integer[] koin;
    static Integer[] monster;
    static String kotak[]=new String[500];
    static int jumlahMonster = 0;
    static int jumlahKoint = 0;
    static int Score = 100;
    static int jarak = 0;
    static String arah;
    static int pilihan=0, level=0;
    static String[] jenisMonster = {"Cyclop", "Hydra", "Boss"};
    static String[] jenisKoin = {"Platina","Perak", "Emas"};
    static int[] nilaiMonster = {5, 10, 15};
    static int[] nilaikoin = {10, 15, 20};
    static int posisiKodok = 0;
    static boolean posisiAman = true;
    static String ContinueGame;


    public static void main(String[] args){
        

        viewLevel();
        koin = new Integer[jumlahKoint];
        monster = new Integer[jumlahMonster];
        AngkaRandom();
        start();
    
        in.close();
    }



    // fungsi start game 
    static void start(){
        while(posisiKodok >= 0 && posisiKodok < 499 && Score >= 0){
            System.out.println("\nPosisi Kodok : " + posisiKodok);
            System.out.println("Score anda : " + Score);

            // melihat posisi kodok di dalam index, matikan komen jika ingin melihat!

                /*for(int i=0; i<kotak.length; i++){
                    if(posisiKodok == i){
                        System.out.print("k\t|");
                    }
                    else{
                        System.out.print(i+ "\t|");
                        
                    }   
                    if(i % 10 == 9){
                        System.out.println();
                    }     
                }*/
            
            viewLangkah();
            
        }
    }

    // fungsi rules dan input level pemain
    static void viewLevel(){
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|                    .... Selamat datang di Permainan! ....                      |");
        System.out.println("|                    ...... Lompat hai katak, lompat!......                      |");
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|                         ----------- RULES -----------                          |");
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("| Pada permainan ini katak akan meloncat-loncat dari satu kotak ke kotak         |");
        System.out.println("| lainnya. Kotak tempat permainan yang tersedia sejumlah 500 kotak pemain        |");
        System.out.println("| diminta untuk memilih langkah [maju/mundur] sebanyak 1 - 2 langkah di          |");
        System.out.println("| dalam kotak terdapat koin dan monster yang berbeda-beda jenis, setiap          |");
        System.out.println("| jenis memiliki nilainya masing-masing.                                         |");
        System.out.println("+--------------------------------------------------------------------------------+");  
        System.out.println("|                        .......... CARA BERMAIN ........                        |");
        System.out.println("|                                                                                |");
        System.out.println("| Pada awal permainan, pemain diharapkan menentukan Level yang terdiri dari      |");
        System.out.println("|  - level EASY - JUMLAH MONSTER = 100, JUMLAH KOIN = 200                        |");
        System.out.println("|  - level INTERMEDIATE - JUMLAH MONSTER = 150, JUMLAH KOIN = 150                |");
        System.out.println("|  - level HARD - JUMLAH MONSTER = 200, JUMLAH KOIN = 100                        |");
        System.out.println("|                                                                                |");
        System.out.println("| Semua jenis Monster dan Koin akan di acak dalam kotak, jika pemain melangkah   |");
        System.out.println("| pada kotak monster, maka Score pemain akan di kurang dengan jumlah tergantung  |");
        System.out.println("| jenis monster.dan jika pemain melangkah pada koin, Score pemain akan di tambah |");
        System.out.println("| dengan jumlah jenis koin                                                       |");
        System.out.println("|                                                                                |");
        System.out.println("| JENIS KOIN           - PLATINA, Jumlah point 10                                |");
        System.out.println("|                      - SILVER, Jumlah point 15                                 |");
        System.out.println("|                      - EMAS, Jumlah point 20                                   |");
        System.out.println("|                                                                                |");
        System.out.println("| JENIS MONSTER        - CYCLOP, Jumlah point 5                                  |");
        System.out.println("|                      - HYDRA, Jumlah point 10                                  |");
        System.out.println("|                      - BOSS, Jumlah point 15                                   |");
        System.out.println("|                                                                                |");
        System.out.println("+--------------------------------------------------------------------------------+"); 
        System.out.println("+-----------------------+"); 
        System.out.println("| Pilihlah level:       |");
        System.out.println("+-----------------------+"); 
        System.out.println("| 1. easy               |");
        System.out.println("| 2. intermediate       |");
        System.out.println("| 3. hard               |");
        System.out.println("+-----------------------+"); 
        System.out.print("Piliahan :");
        level = in.nextInt();

        switch(level){
            case 1:
                jumlahMonster = 100;
                jumlahKoint = 200;
                break;
            case 2:
                jumlahMonster = 150;
                jumlahKoint = 150;
                break;
            case 3:
                jumlahMonster = 200;
                jumlahKoint = 100;
                break;
            default:
                System.out.println("Masukkan Nilai yang Valid!!");

        }
    }

    // fungsi input langkah pemain
    static void viewLangkah(){
        System.out.println("+----------------------------+"); 
        System.out.println("| Tentukan langkah anda!     |");
        System.out.println("+----------------------------+"); 
        System.out.println("| 1. Bergerak maju 1 index   |");
        System.out.println("| 2. Bergerak maju 2 index   |");
        System.out.println("| 3. Bergerak mundur 1 index |");
        System.out.println("| 4. Bergerak mundur 2 index |");
        System.out.println("+----------------------------+"); 
        System.out.print("Pilihan :");
        pilihan = in.nextInt();

        switch(pilihan){
            case 1:
                jarak = 1;
                arah = "maju";
                break;
            case 2:
                jarak = 2;
                arah = "maju";
                break;
            case 3:
                jarak = 1;
                arah = "mundur";
                break;
            case 4:
                jarak = 2;
                arah = "mundur";
                break;
            default:
                System.out.println("Masukkan Inputan Yang Validd!!!");
                break;
        }

        // cek arah
        if(arah.equals("maju")){
            posisiKodok = posisiKodok + jarak;
        }else{
            posisiKodok = posisiKodok - jarak;
        }
            
        // cek score
        for(int j=0; j<jenisMonster.length; j++){
            EndGame();
            if( kotak[posisiKodok-1] == jenisMonster[j]){
                
                Score -= nilaiMonster[j];
                System.out.println("\n....... bertemu monster ........");
                System.out.println("........... "+jenisMonster[j]+" ............");
                System.out.println("score dikurangi : "+ nilaiMonster[j] + " point");
                posisiAman = false;
                break;
            }
        }
        for(int j=0; j<jenisKoin.length; j++){
            EndGame();
            if( kotak[posisiKodok-1] == jenisKoin[j]){
                Score += nilaikoin[j];
                System.out.println("\n....... mendapat koint ........");
                System.out.println("........... "+jenisKoin[j]+" ...........");
                System.out.println("score ditambah : "+ nilaikoin[j] + " point");
                posisiAman = false;
                break;
            }
        }
        if (posisiAman){
            System.out.println("\n....... posisi aman tidak bertemu monstar! ........");
        }
        
        posisiAman = true;
    }

    
    // fungsi acak monster koin
    static void AcakMonsterKoin(){
        int pickMons = 0;
        int pickKoin = 0;

        for(int i=0; i<monster.length; i++){
            pickMons = randNum.nextInt(jenisMonster.length);
            kotak[monster[i]] = jenisMonster[pickMons]; 
        }
        for(int i=0; i<koin.length; i++){
            pickKoin = randNum.nextInt(jenisKoin.length);
            kotak[koin[i]] = jenisKoin[pickKoin]; 
        }
    }




    // fungsi random
    static void AngkaRandom(){
        Set<Integer>list = new LinkedHashSet<Integer>();
        while (list.size() < koin.length + monster.length) {
            list.add(randNum.nextInt(500));  
        }
        
        //convert linked ke array
        Integer[] AllRandom = new Integer[list.size()];
        AllRandom = list.toArray(AllRandom);

        //memecah array AllRandom menjadi 2 array berbeda
        System.arraycopy(AllRandom,0, koin ,0, koin.length);
        System.arraycopy(AllRandom, koin.length, monster, 0, monster.length);

        AcakMonsterKoin();

        //melihat hasil acak, matikan komen jika ingin melihat!

                /*for(int j = 0 ; j < kotak.length; j++){
                    if( kotak[j] == null){
                        System.out.print(" kosong ");
                    }else{
                        System.out.print(" "+kotak[j]+" ");
                    }
                        
                    if(j % 10 == 9){
                        System.out.println();
                    }
                } */

    }

    // fungsi endGame
    static void EndGame(){
        if(posisiKodok >= 499 || Score < 0){
            System.out.println("+---------------------------------------+");
            System.out.println("| PERMAINAN TELAH BERAKHIR!!!           |");
            if(Score > 1500){
                System.out.println("| Score anda : "+Score+ "                     |");
                System.out.println("| Selamat, Anda Meraih Score EXCELLENT! |");
                System.out.println("+---------------------------------------+");
                MainLagi();
            }
            else if(Score >= 500 && Score <= 1500){
                System.out.println("| Score anda : "+Score+ "                     |");
                System.out.println("| Selamat, Anda Meraih Score GOOD!      |");
                System.out.println("+---------------------------------------+");
                MainLagi();
            }
            else if(Score < 500){
                System.out.println("| Score anda : "+Score+ "                     |");
                System.out.println("| Maaf, Anda Meraih Score BAD!          |");
                System.out.println("| Semoga Beruntung Lain Kali            |");
                System.out.println("+---------------------------------------+");
                MainLagi();
            }
        }

        if(posisiKodok < 0){
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("| Posisi Katak Berada Di ujung kiri, Masukkan Inputan agar katak Maju!!! |");
            System.out.println("| SILAHKAN COMPILE ULANG PROGRAM GAMES :)                                |");
            System.out.println("+------------------------------------------------------------------------+");
            
        }
    }

    //fungsi rematch
    public static void MainLagi(){
        System.out.println("APAKAH ANDA INGIN MELANJUTKAN PERMAINAN");
        System.out.print("[yes/no] : ");
        ContinueGame = in.nextLine();
        if(ContinueGame.equals("yes") || ContinueGame.equals("YES")){
            posisiKodok = 1;
            Score = 100;
            System.out.println("SELAMAT MELANJUTKAN GAMES, SEMOGA BERUNTUNG!");
        }
        else if(ContinueGame.equals("no") || ContinueGame.equals("NO")){
            System.out.println("TERIMA KASIH TELAH BERMAIN, SEE YOU AGAIN :)");
            posisiKodok = -1;
        }
        else{
            MainLagi();
        }
    }


}


