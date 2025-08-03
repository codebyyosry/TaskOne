package com.yosry.dev.taskone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yosry.dev.taskone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsingProfileScaffoldPinnedSimple(
    title: String,
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    onBackClick: () -> Unit,
    backgroundImage: Painter,
    avatarImage: Painter,
    avatarSize: Dp = 72.dp,
    content: @Composable (selectedTab: Int) -> Unit
) {
    // We no longer need the Scaffold and nestedScroll for this approach.
    // The entire screen will be a LazyColumn.
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        // 1. Background Image (not sticky)
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = backgroundImage,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // 2. A single sticky header that contains the App Bar, Avatar, and Tabs
        stickyHeader {
            Column(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
                // Top App Bar
                TopAppBar(
                    title = { Text(title) },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )

                // Avatar + Name Header
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Image(
                        painter = avatarImage,
                        contentDescription = "Profile avatar",
                        modifier = Modifier
                            .size(avatarSize)
                            .clip(CircleShape)
                            .background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text("John Doe", style = MaterialTheme.typography.titleLarge)
                        Text("Android Developer", style = MaterialTheme.typography.bodyMedium)
                    }
                }

                // Tabs Header
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    tabs.forEachIndexed { index, tab ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { onTabSelected(index) },
                            text = { Text(tab) }
                        )
                    }
                }
            }
        }

        // 3. Tab content
        item {
            content(selectedTabIndex)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CollapsingProfileScaffoldPinnedSimplePreview() {
    val tabs = listOf("Posts", "About", "Photos")
    var selectedTab by remember { mutableStateOf(0) }

    // Using a Scaffold here just for the preview to provide a theme context,
    // but the component itself doesn't require it.
    Scaffold { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            CollapsingProfileScaffoldPinnedSimple(
                title = "Profile",
                tabs = tabs,
                selectedTabIndex = selectedTab,
                onTabSelected = { selectedTab = it },
                onBackClick = { /* Handle back */ },
                backgroundImage = painterResource(id = R.drawable.ic_app_logo), // Your image here
                avatarImage = painterResource(id = R.drawable.ic_app_logo) // Your avatar here
            ) { selectedTabIndex ->
                Column {
                    repeat(30) { i ->
                        Text(
                            text = "${tabs[selectedTabIndex]} Item $i",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}