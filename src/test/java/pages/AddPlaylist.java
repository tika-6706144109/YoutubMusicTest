package pages;

import base.PageObject;
import org.openqa.selenium.By;

public class AddPlaylist extends PageObject {

    By searchIcon = By.id("icon");

    By searchResult = By.id("browse-page");

    By searchBar = By.xpath("//input[@class='style-scope ytmusic-search-box']");

    By song = By.xpath("//a[@aria-label='Serenata Jiwa Lara (feat. Dian Sastrowardoyo)']");

    By playlist = By.xpath("//ytmusic-playlist-add-to-option-renderer[@class='style-scope ytmusic-add-to-playlist-renderer']");

    By player = By.xpath("//div[@class='middle-controls style-scope ytmusic-player-bar']");

    By content = By.xpath("/html[1]/body[1]/ytmusic-app[1]/ytmusic-app-layout[1]/ytmusic-player-bar[1]/div[2]/div[3]/ytmusic-menu-renderer[1]/tp-yt-paper-icon-button[1]/tp-yt-iron-icon[1]");

    By addToPlaylist = By.xpath("/html[1]/body[1]/ytmusic-app[1]/ytmusic-popup-container[1]/tp-yt-iron-dropdown[1]/div[1]/ytmusic-menu-popup-renderer[1]/tp-yt-paper-listbox[1]/ytmusic-menu-navigation-item-renderer[2]/a[1]");

    By skipAds = By.xpath("/html[1]/body[1]/ytmusic-app[1]/ytmusic-app-layout[1]/ytmusic-player-page[1]/div[1]/div[1]/ytmusic-player[1]/div[2]/div[1]/div[1]/div[13]/div[1]/div[3]/div[1]/div[2]/span[1]/button[1]");

    public void openPage() {
        openUrl("https://music.youtube.com/");
    }

    public void typeSearch(CharSequence... query) {
        type(searchBar, query);
    }

    public void clickBtnSearch(){
        click(searchIcon);
    }

    public void clickSong(){
        click(song);
    }

    public void clickThreeDots() throws InterruptedException {
        if (isDisplayed(skipAds)) {
            click(skipAds);
            Thread.sleep(1000);
            click(content);
        } else {
            click(content);
        }
    }

    public void clickAddToPlaylist(){
        click(addToPlaylist);
    }

    public void clickPlaylist(){
        click(playlist);
    }

    public boolean searchResultDisplayed(){
        return isDisplayed(searchResult);
    }

    public boolean musicIsPlayed(){
        return isDisplayed(player);
    }
}
