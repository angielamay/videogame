public class AngieGame{
    private Grid grid;
    private int userRow;
    private int msElapsed;
    private int timesGet;
    private int timesAvoid;
    //user image update files
    private String normal = "coolremy.gif";
    private String userImage = normal;
    private String gag = "gagremy.png";
    private String yummy = "remy3.gif";
    private String yummyTomato = "tomatograb.png";
    private String yummyBellPepper = "bellgrab.png";
    private String yummyZucchini = "zucchinigrab.png";
    private String yummyEggPlant = "eggplantgrab.png";
    private String yummyOnion = "oniongrab.png";
    private String yummyGarlic = "garlicgrab.png";
    private String yummySquash = "squashgrab.png";
    private String yummyBasil = "basilgrab.png";
    //Creating private Strings for all of the getter images
    private String tomImage;
    private String bellImage;
    private String zuccImage;
    private String eggpImage;
    private String oniImage;
    private String garImage;
    private String sqImage;
    private String basImage;
    //Creating private Strings for all of the avoid images
    private String sushImage;
    private String ramImage;
    private String pizImage;
    private String tacImage;
    private String panImage;
    private String hotImage;
    private String eggImage;
    private String burgImage;

    //Creating boolean variables for all of the getter images to help with the game over method
    boolean tomato = false;
    boolean bellPepper = false;
    boolean zucchini = false;
    boolean eggplant = false;
    boolean onion = false;
    boolean garlic = false;
    boolean squash = false;
    boolean basil = false;
    public AngieGame(){
        grid = new Grid(5, 10);
        userRow = 2;
        msElapsed = 0;
        timesGet = 0;
        timesAvoid = 0;
        updateTitle();
        //Providing values within this Private String variables to add in the images.
        tomImage = "tomato.gif";
        bellImage = "bellpepper.gif";
        zuccImage = "zucchini.gif";
        eggpImage = "eggplant1.gif";
        oniImage = "onion.gif";
        garImage = "garlic1.png";
        sqImage = "squash.gif";
        basImage = "basil1.gif";

        sushImage = "sushi.gif";
        ramImage = "ramen.gif";
        pizImage = "pizza.gif";
        tacImage = "taco.gif";
        panImage = "pancakes.gif";
        hotImage = "hotdog.gif";
        eggImage = "egg.gif";
        burgImage = "burger1.gif";

        try{
            LeFestin song = new LeFestin("LeFestin.wav");
            song.play();
        } catch(Exception e){
            System.out.println(e);
        }

        //Setting the bottom left and bottom right corner to have the ratatouille dish.
        grid.setImage(new Location(userRow, 0), userImage);
        grid.setImage(new Location(4, 9), "dish.png");
        grid.setImage(new Location(grid.getNumRows() - 1, 0), "dish.png");
    }

    public void play(){
        while (!isGameOver()){
            grid.pause(100);
            handleKeyPress();
            if (msElapsed % 400 == 0){
                scrollLeft();
                populateRightEdge();
                setRemy();
            }
            updateTitle();
            msElapsed += 100;
        }
    }

    public void setRemy(){
        //This method allows the user image to change depending on what he hits, whether it is a getter or an avoid
        if (msElapsed % 1000 == 0){
            userImage = normal;
            grid.setImage(new Location(userRow, 0), userImage);
        }
    }

    public void handleKeyPress(){
        int key = grid.checkLastKeyPressed();
        //Allowing Remy to move up and down

        if (key == 38 && userRow > 0){
            grid.setImage(new Location(userRow, 0), null);
            userRow--;
            grid.setImage(new Location(userRow, 0), userImage);
        }
        if (key == 40 && userRow < grid.getNumRows() - 2){
            grid.setImage(new Location(userRow, 0), null);
            userRow++;
            grid.setImage(new Location(userRow, 0), userImage);
        }
        handleCollision(new Location(userRow, 0));
    }

    public int randomizer(int min, int max){
        //Creating a randomizer to have all of the images randomly populate
        int rollDice = (int)(min + Math.random() * (max - min) + 1);
        return rollDice;
    }

    public void populateRightEdge(){
        //randomly places the get gifs
        int tomato = randomizer(0, 60);
        if (tomato == 60){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), tomImage);
        }
        int bellPepper = randomizer(0, 60);
        if (bellPepper == 60){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), bellImage);
        }
        int zucchini = randomizer(0, 60);
        if (zucchini == 60){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), zuccImage);
        }
        int eggplant = randomizer(0, 60);
        if (eggplant == 60){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), eggpImage);
        }
        int onion = randomizer(0, 60);
        if (onion == 60){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), oniImage);
        }
        int garlic = randomizer(0, 60);
        if (garlic == 60){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), garImage);
        }
        int squash = randomizer(0, 60);
        if (squash == 60){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), sqImage);
        }
        int basil = randomizer(0, 60);
        if (basil == 60){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), basImage);
        }
        //randomly places the avoid gifs
        int sushi = randomizer(0, 10);
        if (sushi == 10){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), sushImage);
        }
        int pizza = randomizer(0, 10);
        if (pizza == 10){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), pizImage);
        }
        int ramen = randomizer(0, 10);
        if (ramen == 10){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), ramImage);
        }
        int hotdog = randomizer(0, 10);
        if (hotdog == 10){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), hotImage);
        }
        int egg = randomizer(0, 20);
        if (egg == 10){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), eggImage);
        }
        int taco = randomizer(0, 20);
        if (taco == 10){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), tacImage);
        }
        int pancakes = randomizer(0, 20);
        if (pancakes == 10){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), panImage);
        }
        int burger = randomizer(0, 20);
        if (burger == 10){
            int math = (int)(Math.random() * 4);
            grid.setImage(new Location(math, grid.getNumCols() - 1), burgImage);
        }
    }

    public void scrollLeft(){
        Location collision = new Location(userRow, 1);
        handleCollision(collision);
        for (int row = 0; row < grid.getNumRows() - 1; row++){
            for (int col = 1; col < grid.getNumCols(); col++){
                String image = grid.getImage(new Location(row, col));
                grid.setImage(new Location(row, col), null);
                grid.setImage(new Location(row, col - 1), image);
                grid.setImage(new Location(userRow, 0), userImage);
            }
        }
        grid.setImage(new Location(userRow, 0), userImage);
    }

    public void handleCollision(Location loc){
        //This method handles the collision of the user and the get images and avoid gifs.
        //This method will place an image on the bottom row depending on the ingredient you picked up
        //This method will get rid of an ingredient on the bottom row depending on the avoid image you hit
        String image = grid.getImage(loc);
        if (image != null){
            if (image.equals(tomImage)){
                tomato = true;
                timesGet++;
                userImage = yummyTomato;
                grid.setImage(new Location(userRow, 0), userImage);
                grid.setImage(new Location(4, 1), tomImage);
            }
            if (image.equals(bellImage)){
                bellPepper = true;
                timesGet++;
                userImage = yummyBellPepper;
                grid.setImage(new Location(userRow, 0), userImage);
                grid.setImage(new Location(4, 2), bellImage);
            }
            if (image.equals(eggpImage)){
                eggplant = true;
                timesGet++;
                userImage = yummyEggPlant;
                grid.setImage(new Location(userRow, 0), userImage);
                grid.setImage(new Location(4, 4), eggpImage);
            }
            if (image.equals(oniImage)){
                onion = true;
                timesGet++;
                userImage = yummyOnion;
                grid.setImage(new Location(userRow, 0), userImage);
                grid.setImage(new Location(4, 5), oniImage);
            }
            if (image.equals(zuccImage)){
                zucchini = true;
                timesGet++;
                userImage = yummyZucchini;
                grid.setImage(new Location(userRow, 0), userImage);
                grid.setImage(new Location(4, 3), zuccImage);
            }
            if (image.equals(garImage)){
                garlic = true;
                timesGet++;
                userImage = yummyGarlic;
                grid.setImage(new Location(userRow, 0), userImage);
                grid.setImage(new Location(4, 6), garImage);
            }
            if (image.equals(sqImage)){
                squash = true;
                timesGet++;
                userImage = yummySquash;
                grid.setImage(new Location(userRow, 0), userImage);
                grid.setImage(new Location(4, 7), sqImage);
            }
            if (image.equals(basImage)){
                basil = true;
                timesGet++;
                userImage = yummyBasil;
                grid.setImage(new Location(userRow, 0), userImage);
                grid.setImage(new Location(4, 8), basImage);
            }
            //The avoid image section of the method. This will change the user image and get rid of an ingredient on the bottom row.
            if (image.equals(sushImage)){
                garlic = false;
                grid.setImage(new Location(4, 6), null);
                userImage = gag;
                grid.setImage(new Location(userRow, 0), userImage);
            }
            if (image.equals(pizImage)){
                bellPepper = false;
                grid.setImage(new Location(4, 2), null);
                userImage = gag;
                grid.setImage(new Location(userRow, 0), userImage);
            }
            if (image.equals(ramImage)){
                zucchini = false;
                grid.setImage(new Location(4, 3), null);
                userImage = gag;
                grid.setImage(new Location(userRow, 0), userImage);
            }
            if (image.equals(hotImage)){
                basil = false;
                grid.setImage(new Location(4, 8), null);
                userImage = gag;
                grid.setImage(new Location(userRow, 0), userImage);
            }
            if (image.equals(tacImage)){
                onion = false;
                grid.setImage(new Location(4, 5), null);
                userImage = gag;
                grid.setImage(new Location(userRow, 0), userImage);
            }
            if (image.equals(panImage)){
                eggplant = false;
                grid.setImage(new Location(4, 4), null);
                userImage = gag;
                grid.setImage(new Location(userRow, 0), userImage);
            }
            if (image.equals(eggImage)){
                squash = false;
                grid.setImage(new Location(4, 7), null);
                userImage = gag;
                grid.setImage(new Location(userRow, 0), userImage);
            }
            if (image.equals(burgImage)){
                tomato = false;
                grid.setImage(new Location(4, 1), null);
                userImage = gag;
                grid.setImage(new Location(userRow, 0), userImage);
            }
        }
    }

    public void updateTitle(){
        grid.setTitle("Game: Bon Appetit! Complete your Ratatouille dish!");
    }

    public boolean isGameOver(){
        //If you can catch all of the ingredients and have them listed on the bottom row, you win!
        //If you have hit at least one ingredient but then have hit enough avoid images to make the bottom row empty, you lose!
        if (tomato && bellPepper && eggplant && onion && zucchini && garlic && squash && basil){
            for (int row = 0; row < grid.getNumRows() - 1; row++){
                for (int col = 0; col < grid.getNumCols(); col++){
                    grid.setImage(new Location(row, col), null);
                    grid.setImage(new Location(2, 4), "iloveit.jpg");
                    grid.setImage(new Location(1, 4), "youwon!.png");
                }
            }
            return true;
        } else if (timesGet >= 1 && tomato == false && bellPepper == false && eggplant == false && onion == false && 
        zucchini == false && garlic == false && squash == false && basil == false){
            for (int row = 0; row < grid.getNumRows() - 1; row++){
                for (int col = 0; col < grid.getNumCols(); col++){
                    grid.setImage(new Location(row, col), null);
                    grid.setImage(new Location(2, 4), "endremy.png");
                    grid.setImage(new Location(1, 4), "youlose.png");
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void test(){
        AngieGame game = new AngieGame();
        game.play();
    }

    public static void main(String[] args){
        test();
    }
}