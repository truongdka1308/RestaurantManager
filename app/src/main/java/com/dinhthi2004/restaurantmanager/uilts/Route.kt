package com.dinhthi2004.restaurantmanager.uilts

sealed class Route(val screen: String) {
    // Manager
    data object HomeManager:Route("HomeManager")
    data object BottomNavigation:Route("BottomNavigation")
    data object HomeEmployee:Route("HomeEmployee")
    data object HomeTable:Route("HomeTable")
    data object HomeOrder:Route("HomeOrder")
    data object HomeIngredients:Route("HomeIngredients")
    data object HomeRevenue:Route("HomeRevenue")
    data object HomeSetting:Route("HomeSetting")
    data object Setting:Route("Setting")
}