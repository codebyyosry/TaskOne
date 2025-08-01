// File: CustomAppTopBar.kt

package com.yosry.dev.taskone.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    subtitle: String? = null,
    isBackEnabled: Boolean = false,
    isSearchEnabled: Boolean = false,
    isOptionsEnabled: Boolean = false,
    isLoading: Boolean = false,
    useCenterAligned: Boolean = false,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    elevation: Dp = 4.dp,
    navigationIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    onBackClick: (() -> Unit)? = null,
    onSearchClick: (() -> Unit)? = null,
    optionsMenuItems: List<Pair<String, () -> Unit>> = emptyList(),
    customActions: @Composable RowScope.() -> Unit = {}
) {
    var isOptionsMenuExpanded by remember { mutableStateOf(false) }

    val titleContent: @Composable () -> Unit = {
        Column(modifier = Modifier.testTag("AppTopBarTitleColumn")) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.testTag("AppTopBarTitle")
            )
            subtitle?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.testTag("AppTopBarSubtitle")
                )
            }
        }
    }

    val actionsContent: @Composable RowScope.() -> Unit = {
        if (isSearchEnabled && onSearchClick != null) {
            IconButton(
                onClick = onSearchClick, modifier = Modifier.testTag("AppTopBarSearch")
            ) {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = "Search"
                )
            }
        }
        customActions()
        if (isOptionsEnabled && optionsMenuItems.isNotEmpty()) {
            Box {
                IconButton(
                    onClick = { isOptionsMenuExpanded = true },
                    modifier = Modifier.testTag("AppTopBarOptions")
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert, contentDescription = "Options"
                    )
                }
                DropdownMenu(
                    expanded = isOptionsMenuExpanded,
                    onDismissRequest = { isOptionsMenuExpanded = false }) {
                    optionsMenuItems.forEachIndexed { index, item ->
                        DropdownMenuItem(onClick = {
                            isOptionsMenuExpanded = false
                            item.second()
                        }, modifier = Modifier.testTag("AppTopBarOptionItem$index"), text = {
                            Text(text = item.first)
                        })
                    }
                }
            }
        }
    }

    val navIconContent: (@Composable (() -> Unit))? = if (isBackEnabled && onBackClick != null) {
        {
            IconButton(
                onClick = onBackClick, modifier = Modifier.testTag("AppTopBarBack")
            ) {
                Icon(
                    imageVector = navigationIcon, contentDescription = "Navigation"
                )
            }
        }
    } else null

    Surface(
        color = backgroundColor, contentColor = contentColor, tonalElevation = elevation
    ) {
        Column(modifier = Modifier.zIndex(1f)) {
            if (useCenterAligned) {
                CenterAlignedTopAppBar(
                    title = titleContent,
                    navigationIcon = navIconContent ?: {},
                    actions = actionsContent,
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                TopAppBar(
                    title = titleContent, navigationIcon = {
                        navIconContent?.invoke()
                    }, actions = {
                        actionsContent
                    }, colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = backgroundColor,
                        titleContentColor = contentColor,
                        actionIconContentColor = contentColor,
                        navigationIconContentColor = contentColor
                    )
                )
            }
            val progress = 0.5f  // example value

            if (isLoading) {
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .testTag("AppTopBarLoading"),
                    color = contentColor.copy(alpha = 0.7f),
                    trackColor = ProgressIndicatorDefaults.linearTrackColor,
                    strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview_Minimal() {
    AppTopBar(title = "Home")
}

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview_Full() {
    AppTopBar(
        title = "Dashboard",
        subtitle = "Welcome back",
        isBackEnabled = true,
        isSearchEnabled = true,
        isOptionsEnabled = true,
        isLoading = true,
        onBackClick = {},
        onSearchClick = {},
        optionsMenuItems = listOf("Settings" to {}, "Logout" to {}),
        customActions = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Info, contentDescription = "Help")
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsingAppTopBarScreen() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text("Collapsing Title", modifier = Modifier.testTag("CollapsingTitle"))
                }, navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }, actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Options")
                    }
                }, scrollBehavior = scrollBehavior
            )
        }, modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(50) { index ->
                Text(
                    text = "Item $index", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CollapsingAppTopBarScreenPreview() {
    CollapsingAppTopBarScreen()
}