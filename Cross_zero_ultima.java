import java.util.Scanner;
import java.util.Random;
public class Cross_zero_ultima{
	public static void main(String args[]){// рандомайзер   
		Random rnd = new Random();

		int fill = 0;//есть ли знак или пусто
		int value = 0; //крестик или нолик 1-крест 0-нолик 

		for (int xod=1;xod<=9;xod++){// 9 ходов которые мы делаем, но мы должны делать 5 ходов а бот 4
			int row = 0;
			int col = 0; 
			Scanner in = new  Scanner(System.in);
			int shift = 0;
			if (xod % 2 ==1){//наш ход выбор строки и столбца
				System.out.println("input row");
				row = in.nextInt();
				System.out.println("input col");
				col =in.nextInt();
				System.out.println();
				shift =row*3 - col;
			} else{//рандомайзер собственно говоря
				System.out.println("ход противника");
				int z = 1;
				boolean d = false;
				while (d == false) {
					row=rnd.nextInt(3)+1;
					col=rnd.nextInt(3)+1;
					shift =row*3 - col;
					if ((fill&(z<<shift))==0){
						d=true;
					}
				}
				
			}
			int a= 1;

			if ((fill>>shift) % 2 ==0){//проверка на неповторяемость клетки + то наскольок смещаестя а 
				a=a<<shift;
			} else{//запуск цикла с еще раз с той же переменной xod
				System.out.println("неправильный ход попробуй еще раз");
				xod--;
				continue;
			}

			fill= fill | a;
			if (xod % 2 == 1){//заполнять value 1 нужно только когда наш ход
				value = value | a;
			}		

			System.out.println("____");
			for (row = 1; row <=3; row++) {//визуальное заполнение поля
				for (col = 1; col <=3; col++) {
					shift = row*3-col; 
					int mask = 1<<shift;
					char c =' ';
					if ((fill & mask) >0){//если клетка заполнена 
						if ((value & mask)>0) {
							c='x';
						} else{
							c='0';
						}
					} else {
						c=' ';
					}
					System.out.print(c);

				}
				System.out.println();
			}
			System.out.println("____");

			// циклы на проверку победы
			if ((fill&0b111) ==0b111){//000_000_111
				if ((value&0b111 )== 0b111){
					System.out.println("победа");
					System.exit(0);
				} else if ((value&0b111 )== 0) {
					System.out.println("поражение");
					System.exit(0);
					}
			}
			if ((fill&0b111000) ==0b111000){//000_111_000
				if ((value&0b111000 )== 0b111000){
					System.out.println("победа");
					System.exit(0);
				} else if ((value&0b111000 )== 0) {
					System.out.println("поражение");
					System.exit(0);
					}
			}
			if ((fill&0b111_000_000) ==0b111_000_000){//111_000_000
				if ((value&0b111_000_000)== 0b111_000_000){
					System.out.println("победа");
					System.exit(0);
				} else if ((value&0b111_000_000 )== 0) {
					System.out.println("поражение");
					System.exit(0);
					}
			}

			if ((fill&0b1_001_001) ==0b1_001_001){///001_001_001
				if ((value&0b1_001_001 )== 0b1_001_001){
					System.out.println("победа");
					System.exit(0);
				} else if ((value&0b1_001_001 )== 0) {
					System.out.println("поражение");
					System.exit(0);
					}
			}
			if ((fill&0b10_010_010) ==0b10_010_010){//010_010_010
				if ((value&0b10_010_010 )== 0b10_010_010){
					System.out.println("победа");
					System.exit(0);
				} else if ((value&0b10_010_010 )== 0) {
					System.out.println("поражение");
					System.exit(0);
					}
			}
			if ((fill&0b100_100_100) ==0b100_100_100){//100_100_100
				if ((value&0b100_100_100 )== 0b100_100_100){
					System.out.println("победа");
					System.exit(0);
				} else if ((value&0b100_100_100 )== 0) {
					System.out.println("поражение");
					System.exit(0);
					}
			}

			if ((fill&0b1_010_100) ==0b1_010_100){//001_010_100
				if ((value&0b1_010_100 )== 0b1_010_100){
					System.out.println("победа");
					System.exit(0);
				} else if ((value&0b1_010_100 )== 0) {
					System.out.println("поражение");
					System.exit(0);
					}
			}
			if ((fill&0b100_010_001) ==0b100_010_001){//100_010_001
				if ((value&0b100_010_001 )== 0b100_010_001){
					System.out.println("победа");
					System.exit(0);
				} else if ((value&0b100_010_001 )== 0) {
					System.out.println("поражение");
					System.exit(0);
					}
			}
		}
		if (fill == 0b111111111){
			System.out.println("ничья");
		}
	}
}