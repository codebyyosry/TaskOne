import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
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
    // Renamed for clarity: this is now called when search is submitted
    onSearchSubmit: (String) -> Unit = {},
    optionsMenuItems: List<Pair<String, () -> Unit>> = emptyList(),
    customActions: @Composable RowScope.() -> Unit = {}
) {
    // State to track if the search bar is active
    var isSearchActive by remember { mutableStateOf(false) }
    // State to hold the search query text
    var searchQuery by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        tonalElevation = elevation,
        modifier = Modifier.zIndex(1f)
    ) {
        Column {
            // Conditionally display either the search bar or the normal app bar
            if (isSearchActive) {
                SearchAppBar(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it },
                    onClose = {
                        isSearchActive = false
                        searchQuery = "" // Clear search query when closing
                    },
                    onSearchSubmit = {
                        keyboardController?.hide()
                        onSearchSubmit(it)
                    },
                    contentColor = contentColor
                )
            } else {
                NormalAppBar(
                    title = title,
                    subtitle = subtitle,
                    isBackEnabled = isBackEnabled,
                    isSearchEnabled = isSearchEnabled,
                    isOptionsEnabled = isOptionsEnabled,
                    useCenterAligned = useCenterAligned,
                    backgroundColor = backgroundColor,
                    contentColor = contentColor,
                    navigationIcon = navigationIcon,
                    onBackClick = onBackClick,
                    onSearchClick = { isSearchActive = true }, // Activate search mode
                    optionsMenuItems = optionsMenuItems,
                    customActions = customActions
                )
            }

            // The loading indicator is placed here so it's visible in both states
            if (isLoading) {
                // To make the indicator indeterminate (animated), we call it without the progress parameter.
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .testTag("AppTopBarLoading"),
                    color = contentColor.copy(alpha = 0.7f)
                )
            }
        }
    }
}

// Helper composable for the normal app bar content
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NormalAppBar(
    title: String,
    subtitle: String?,
    isBackEnabled: Boolean,
    isSearchEnabled: Boolean,
    isOptionsEnabled: Boolean,
    useCenterAligned: Boolean,
    backgroundColor: Color,
    contentColor: Color,
    navigationIcon: ImageVector,
    onBackClick: (() -> Unit)?,
    onSearchClick: () -> Unit,
    optionsMenuItems: List<Pair<String, () -> Unit>>,
    customActions: @Composable RowScope.() -> Unit
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
        if (isSearchEnabled) {
            IconButton(
                onClick = onSearchClick,
                modifier = Modifier.testTag("AppTopBarSearch")
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
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
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Options"
                    )
                }
                DropdownMenu(
                    expanded = isOptionsMenuExpanded,
                    onDismissRequest = { isOptionsMenuExpanded = false }) {
                    optionsMenuItems.forEachIndexed { index, item ->
                        DropdownMenuItem(
                            onClick = {
                                isOptionsMenuExpanded = false
                                item.second()
                            },
                            modifier = Modifier.testTag("AppTopBarOptionItem$index"),
                            text = { Text(text = item.first) }
                        )
                    }
                }
            }
        }
    }

    val navIconContent: @Composable (() -> Unit)? = if (isBackEnabled && onBackClick != null) {
        {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.testTag("AppTopBarBack")
            ) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = "Navigation"
                )
            }
        }
    } else null

    if (useCenterAligned) {
        CenterAlignedTopAppBar(
            title = titleContent,
            navigationIcon = navIconContent ?: {},
            actions = actionsContent,
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = backgroundColor,
                titleContentColor = contentColor,
                actionIconContentColor = contentColor,
                navigationIconContentColor = contentColor
            ),
            modifier = Modifier.fillMaxWidth()
        )
    } else {
        TopAppBar(
            title = titleContent,
            navigationIcon = { navIconContent?.invoke() },
            actions = actionsContent,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = backgroundColor,
                titleContentColor = contentColor,
                actionIconContentColor = contentColor,
                navigationIconContentColor = contentColor
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}


// Helper composable for the active search bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchAppBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onClose: () -> Unit,
    onSearchSubmit: (String) -> Unit,
    contentColor: Color = Color.Red
) {
    val focusRequester = remember { FocusRequester() }

    // Request focus for the text field when the search bar is first displayed
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent, // Let the Surface handle the color
            navigationIconContentColor = contentColor,
            actionIconContentColor = contentColor
        ),
        // Back arrow to close the search view
        navigationIcon = {
            IconButton(onClick = onClose) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Close Search"
                )
            }
        },
        title = {
            // The TextField for search input
            TextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                placeholder = {
                    Text("Search...", color = contentColor.copy(alpha = 0.7f))
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { onSearchSubmit(query) }),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = contentColor,
                    unfocusedTextColor = contentColor,
                    cursorColor = contentColor,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        },
        // A clear button to empty the text field
        actions = {
            if (query.isNotEmpty()) {
                IconButton(onClick = { onQueryChange("") }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear Search"
                    )
                }
            }
        }
    )// Add these previews to the same file as your AppTopBar.kt
}


// Add these previews to the same file as your AppTopBar.kt

@Preview(showBackground = true, name = "App Top Bar States")
@Composable
private fun AppTopBarStatesPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        // 1. Standard Top Bar with all options enabled
        AppTopBar(
            title = "AppTitle",

            isBackEnabled = true,
            onBackClick = {},

            isSearchEnabled = true,
            isOptionsEnabled = true,
            optionsMenuItems = listOf(
                "Profile" to {},
                "Settings" to {}
            )
        )

        // 2. Center-Aligned Top Bar in a loading state
        AppTopBar(
            title = "Loading Content",
            useCenterAligned = true,
            isLoading = false,
            backgroundColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Active Search Bar")
@Composable
private fun SearchAppBarPreview() {
    // Wrap the content in a Surface to provide the expected background color.
    // The SearchAppBar is designed to be placed on a surface like this.
    Surface(color = MaterialTheme.colorScheme.primary) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Preview for an empty search bar
            SearchAppBar(
                query = "",
                onQueryChange = {},
                onClose = {},
                onSearchSubmit = {},
                contentColor = MaterialTheme.colorScheme.onPrimary
            )

            // Add a divider for visual separation in the preview
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.2f)
            )

            // Preview for a search bar with text
            SearchAppBar(
                query = "Sample search query",
                onQueryChange = {},
                onClose = {},
                onSearchSubmit = {},
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}