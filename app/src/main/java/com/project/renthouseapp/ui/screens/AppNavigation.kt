package com.project.renthouseapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.project.renthouseapp.navigation.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    //lista de itens no menu
    val menuItems = listOf(
        MenuItem(title = "Início", icon = Icons.Default.Home, route = Routes.PropertyList.route),
        MenuItem(title = "Anúncios", icon = Icons.Default.Home, route = Routes.MyListings.route)
    )
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                menuItems.forEach { item ->
                    NavigationDrawerItem(
                        label = { Text(item.title)},
                        icon = { Icon(item.icon, contentDescription = item.title)},
                        selected = currentRoute == item.route,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        Scaffold (
           topBar = {
               TopAppBar(
                   title = {
                       val title = menuItems.find { it.route == currentRoute }?.title ?: "RentHouseApp"
                       Text(title)
                   },
                   navigationIcon = {
                       IconButton(onClick = {
                           scope.launch { drawerState.apply{ if (isClosed) open() else close() } }
                       }) {
                           Icon(Icons.Default.Menu, contentDescription = "Menu")
                       }
                   },
                   colors = TopAppBarDefaults.topAppBarColors(
                       containerColor = MaterialTheme.colorScheme.primaryContainer,
                       titleContentColor = MaterialTheme.colorScheme.onPrimary,
                       navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                   )
               )
           }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Routes.PropertyList.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(Routes.PropertyList.route) {
                    PropertyListScreen()
                }
                composable(Routes.MyListings.route) {
                    MyListingsScreen()
                }
            }
        }
    }
}

data class MenuItem(val title: String, val icon: ImageVector, val route: String)