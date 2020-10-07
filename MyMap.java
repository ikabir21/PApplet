import processing.core.*;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
//import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class MyMap extends PApplet{
	private static final long serialVersionUID = 1L;
	
	public static String mbTilesString = "blankLight-1-3.mbtiles"; //without internet
	private static final boolean offline = false;// true if offline
	
	private UnfoldingMap map;
	public void setup(){
		size(800, 600, P2D);
		this.background(200);
		AbstractMapProvider provider = new Microsoft.HybridProvider();
		int zoomLevel = 10;
		
		if (offline){
			provider = new MBTilesMapProvider(mbTilesString);
			zoomLevel = 3;
		}
		map = new UnfoldingMap(this, 0, 0, 800, 600, provider);
		map.zoomAndPanTo(zoomLevel, new Location(24.7577193, 92.7901042));
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	public void draw() {
		map.draw();		
	}
}