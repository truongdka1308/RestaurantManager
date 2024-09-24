package com.dinhthi2004.restaurantmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dinhthi2004.restaurantmanager.presentation.screen.BottomNavigation
import com.dinhthi2004.restaurantmanager.presentation.screen.auth.login_screen.LoginScreen
import com.dinhthi2004.restaurantmanager.presentation.screen.auth.WelcomeScreen
import com.dinhthi2004.restaurantmanager.presentation.screen.admin.employee.EmployeeScreen
import com.dinhthi2004.restaurantmanager.presentation.screen.admin.home.HomeAdminScreen
import com.dinhthi2004.restaurantmanager.presentation.screen.admin.menu.MenuManagementScreen
import com.dinhthi2004.restaurantmanager.presentation.screen.admin.addnewfood.AddNewFoodScreen
import com.dinhthi2004.restaurantmanager.presentation.screen.admin.restaurant_management.RestaurantManagerScreen
import com.dinhthi2004.restaurantmanager.presentation.screen.admin.revenue_report.RevenueReportScreen
import com.dinhthi2004.restaurantmanager.uilts.Route

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN) {
        //Intro App
        composable(Routes.WELCOME_SCREEN) { WelcomeScreen(navController) }
        composable(Routes.LOGIN_SCREEN) { LoginScreen(navController) }

        //Bottom_Nav
        composable(Routes.HOME_ADMIN_SCREEN) { HomeAdminScreen(navController) }
        composable(Routes.EMPLOYEE_ADMIN) { EmployeeScreen(navController)}
        composable(Routes.REVENUE_REPORTS_ADMIN) { RevenueReportScreen(navController)}
        composable(Routes.RESTAURANT_MANAGER_ADMIN) { RestaurantManagerScreen(navController) }


        //Admin
        composable(Routes.MENU_MANAGEMENT_ADMIN) { MenuManagementScreen(navController) }
        composable(Routes.ADD_NEW_FOOD) { AddNewFoodScreen(navController) }
        //Manager
        composable(Route.BottomNavigation.screen){ BottomNavigation(navController) }

    }
}