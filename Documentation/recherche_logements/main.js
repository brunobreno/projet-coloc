function init()
{

  const parcThabor = {
    lat: 48.11438,
    lng: -1.669494
  }

  const zoomLevel = 10;

  const map = L.map('mapid').setView([parcThabor.lat, parcThabor.lng], zoomLevel);

  const mainLayer =   L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoiZW1taXJpcyIsImEiOiJja3Ywd3V1bnQwYXJnMnZwN2hlMmVubW8xIn0.V0DA8HsnllpOWkInfHi-Ig'
  })

  mainLayer.addTo(map);

}


function slash()
{
  var element = document.getElementById()
}
