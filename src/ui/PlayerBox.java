package ui;

import modele.Track;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;

public class PlayerBox extends VBox{
	
	private WebView webView;
	private ImageView imageView;
	private Image image;
	private Text trackTitle, artistName, albumTitle;

	public PlayerBox(double uI_HEIGHT, double uI_WIDTH) {
		super();
		this.setAlignment(Pos.TOP_LEFT);
		this.setPadding(new Insets(10,10,10,10));
		this.setMaxHeight(uI_HEIGHT);
		this.setMaxWidth(uI_WIDTH*2/5);

		Text playerText = new Text("Player");
		playerText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		this.getChildren().add(playerText);
		
		imageView = new ImageView();
        image = new Image("http://api.deezer.com/album/5965734/image");//TODO JSONObject.getimage
        imageView.setImage(image);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        
        trackTitle = new Text("Track");//TODO JSONObject.getTitle
        artistName = new Text("Artist");//TODO JSONObject.getArtist
        albumTitle = new Text("Album");//TODO JSONObject.getAlbum
        

		VBox trackInfo = new VBox();
		trackInfo.setAlignment(Pos.CENTER);
		trackInfo.setPadding(new Insets(10,10,10,10));
		trackInfo.setMinHeight(uI_HEIGHT/2);
		
        trackInfo.getChildren().add(imageView);
        trackInfo.getChildren().add(trackTitle);
        trackInfo.getChildren().add(artistName);
        trackInfo.getChildren().add(albumTitle);
		this.getChildren().add(trackInfo);
		
        webView = new WebView();
        webView.setMaxHeight(uI_HEIGHT/4);
        this.getChildren().add(webView);
        
        this.loadTrack("http://e-cdn-preview-7.deezer.com/stream/7ed43f379f0f0b3f2527818c8306b63b-3.mp3");
        
	}
	
	public void loadTrack(String url){
		webView.getEngine().load(url);
	}

	public void refresh(Track track) {
		trackTitle.setText(track.getTitle());
		loadTrack(track.getExternalUrl());
	}

}
