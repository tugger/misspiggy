<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    
    <!-- Work in progress! -->
    <xsl:template match="root">
        <html>
            <head>
                <title>report.xsl</title>
            </head>
            <body>
                <table>
                    <xsl:apply-templates select="example"/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="example">
        <tr><td><xsl:value-of select="@key"/></td></tr>
    </xsl:template>

</xsl:stylesheet>
