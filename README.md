This is app made to utilize Maps SDK using Google Cloud Console.
Firstly, a Google Maps View Activity is created on which we will work on.
Then get the API key from the console and add it to the Manifest file.
onMapReady() is implemented here by default so that we can perform actions
on the map after the Map is loaded and ready to use. In this app, we used 
LatLng, Marker, MarkerOptions, GoogleMap classes and OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
and GooogleMap.OnMarkerDragListener interfaces are implemented for adding click and
drag fuctionality to the marker. The markers are to show that they can be dragged if enabled draggable
and their position gets updated with their respective co-ordinates they are dragged to.
The refernce point is GRIET college marker and we move the M marker to it prove that they could move and 
show accurate lat and long points in snippets and Toast message. The OnMarkCLickListener gives Toast msg of
marker Position, MarKerStart,End as it is a custom implementation can 
give drag strt and end co-ordinates of marker in Toast msg .
Note: if you want to use icons try using BitmapDecriptorFactory 
<video src="https://github.com/sanjuray/MapMe/assets/94555333/de4c12a4-43cd-451e-8927-e67cd288f151" width=450 height=550/>


