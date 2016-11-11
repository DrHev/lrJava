import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
	DotCom one = new DotCom();
	one.setName("github.com");
	DotCom two = new DotCom();
	two.setName("vk.com");
	DotCom three = new DotCom();
	three.setName("twitter.com");
	dotComsList.add(one);
	dotComsList.add(two);
	dotComsList.add(three);
	
	System.out.println("Ваша цель - потопить три Сайта.");
	System.out.println("github.com, vk.com, twitter.com");
	System.out.println("Вертикаль - abcdefg, горизонталь - 0-6");
	System.out.println("Попытайтесь потопить их за минимальное количество ходов");
	
	for (DotCom dotComToSet : dotComsList) {
	  ArrayList<String> newLocation = helper.placeDotCom(3);
	  dotComToSet.setLocationCells(newLocation);
	}
     }
     private void startPlaying() { 
	while(!dotComsList.isEmpty()) {
	  String userGuess = helper.getUserInput("Сделайте ход");
	  checkUserGuess(userGuess);
	}
     finishGame();
     }
     private void checkUserGuess(String userGuess) {
	numOfGuesses++;
	String result = "Мимо";
	for (DotCom dotComToTest : dotComsList) {
	  result = dotComToTest.checkYourself(userGuess);
	  if (result.equals("Попал")) {
	    break;
	  }
	  if (result.equals("Потопил")) {
	    dotComsList.remove(dotComToTest);
	    break;
	  }
        }
        System.out.println(result);
      }
      private void finishGame() {
	System.out.println( "Все сайты ушли ко дну! Теперь они кормят рыб");
	if (numOfGuesses <= 18) {
	  System.out.println( "Это заняло у вас всего " + numOfGuesses + " попыток.");
	  System.out.println( "Вы успели покормить рыбок.");
	} else {
	System.out.println( numOfGuesses + " - это слишком много попыток.");
	System.out.println( "Из за тебя, рукожоп, рыбы плавают кверху пузом");
	}
      }
      public static void main (String[] args) {
	DotComBust game = new DotComBust();
	game.setUpGame();
	game.startPlaying();
	}
}
