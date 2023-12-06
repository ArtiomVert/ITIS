package ru.kpfu.itis.group302.game;
import ru.kpfu.itis.group302.players.APlayer;
import ru.kpfu.itis.group302.players.Player;
import java.util.Scanner;
import java.util.Random;
public class Game{
	private APlayer p1;
	private APlayer p2;
	View v = new View();
	public void gameMenu(){
		Scanner inp = new Scanner(System.in);
		boolean f = true;
		while(f){
			v.println("Выберите режим игры:");
			v.println("1.Два игрока");
			v.println("2.Против компьютера");
			v.println("3.Выйти из игры");
			String comand = inp.nextLine();
			switch(comand){
				case "1":
					gamePP();
					break;
				case "2":
					gamePP();
					break;
				case "3":
					f = false;
					break;
				default:
					v.println("Извините, команда не ясна, попробуйте снова :(");
					break;
			}
		}
	}
	
	private void gamePP(){
		Scanner in = new Scanner(System.in);
		p1 = new Player("Player1");
		p2 = new Player("Player2");
		APlayer kicker = p1;
		APlayer enemy = p2;
		while (p1.alive() && p2.alive()) {
			v.println(p1.getName() + " hp:" + p1.getHp() + ", " + p2.getName() + " hp:" + p2.getHp());
			v.print(kicker.getName() + " is going to kick " + enemy.getName() + " with force: ");
			double f = in.nextDouble();
			kicker.kick(enemy, f);
			APlayer swap = kicker;
			kicker = enemy;
			enemy = swap;
		}
		APlayer winner = p1.alive() ? p1: p2;
		v.println(winner + " won.");
	}
}