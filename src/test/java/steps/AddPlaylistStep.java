package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AddPlaylist;

public class AddPlaylistStep {

    AddPlaylist addPlaylist = new AddPlaylist();

    @Given("user is on the open url page")
    public void userOpenYoutubeMusic() {
        addPlaylist.openPage();
    }

    @And("user click search bar")
    public void userClickSearchbar() {
        addPlaylist.clickBtnSearch();
    }

    @And("user input the keyword and click enter")
    public void userInputKeyword() {
        addPlaylist.typeSearch("Dian Sastro");
    }

    @When("the app will show the result")
    public void userShowResult() throws InterruptedException {
        Assert.assertTrue(addPlaylist.searchResultDisplayed());
        Thread.sleep(1000);
    }

    @And("user will click the result")
    public void userClickResult() throws InterruptedException {
        addPlaylist.clickSong();
        Thread.sleep(1000);
    }

    @And("the app will play the music")
    public void userPlayMusic() throws InterruptedException {
        addPlaylist.musicIsPlayed();
        Thread.sleep(10000);
    }

    @And("user will click three dots in player")
    public void userClickThreeDots() throws InterruptedException {
        addPlaylist.clickThreeDots();
    }

    @And("user will click add to playlist")
    public void userClickAddPlaylist() {
        addPlaylist.clickAddToPlaylist();
    }

    @And("user will click the playlist and added to playlist")
    public void userClickPlaylist() {
        addPlaylist.clickPlaylist();
    }
}
