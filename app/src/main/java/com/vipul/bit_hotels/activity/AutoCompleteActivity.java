package com.vipul.bit_hotels.activity;

/**
 * Created by vipulkumar on 30/11/16.
 */

public class AutoCompleteActivity {


    private void initializePlacesSearch() {
//        typeFilter = new AutocompleteFilter.Builder()
//                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ESTABLISHMENT)
//                .setCountry("IN")
//                .build();
//
//        bounds = new LatLngBounds(
//                new LatLng(-33.880490, 151.184363),
//                new LatLng(-33.858754, 151.229596));
//    }
//
//    private void searchAutocomplete(String query) {
//        final PendingResult<AutocompletePredictionBuffer> result =
//                Places.GeoDataApi.
//                        getAutocompletePredictions(mGoogleApiClient, query,
//                                null, typeFilter);
//
//
//        result.setResultCallback(new ResultCallback<AutocompletePredictionBuffer>() {
//            @Override
//            public void onResult(@NonNull AutocompletePredictionBuffer autocompletePredictions) {
//
//                if (autocompletePredictions == null)
//                    return;
//
//                if (autocompletePredictions.getStatus().isSuccess()) {
//                    stationsList.clear();
//                    for (AutocompletePrediction prediction : autocompletePredictions) {
//                        Station station = new Station();
//                        station.setStationName(prediction.getPrimaryText(null).toString());
//                        station.setStationSecondaryText(prediction.getSecondaryText(null).toString());
//                        stationsList.add(station);
//                    }
//                }
//
//                //Prevent memory leak by releasing buffer
//                autocompletePredictions.release();
//
////                Iterator<AutocompletePrediction> iterator = autocompletePredictions.iterator();
////                int i = 0;
////                Toast.makeText(SearchActivity.this, autocompletePredictions.get(0).getPrimaryText(null), Toast.LENGTH_SHORT).show();
////                while (iterator.hasNext()) {
////                    Station station = new Station();
////                    station.setStationName(autocompletePredictions.get(i).getPrimaryText(null).toString());
////                    stationsList.add(station);
////                    i++;
////                }
//                stationsAdapter.notifyDataSetChanged();
//            }
//        });
//    }
    }
}
