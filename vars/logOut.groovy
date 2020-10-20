import dk.legevognen.LogUtilities

void call(String level='INFO', String message="") {
    LogUtilities logUtilities = new LogUtilities(this)

    switch(level.toUpperCase()) {
        case 'SEVERE':
            logUtilities.severe(message)
            break
        case 'WARNING':
            logUtilities.warning(message)
            break
        case 'DEBUG':
            logUtilities.debug(message)
            break
        default:
            logUtilities.info(message)
    }
}
