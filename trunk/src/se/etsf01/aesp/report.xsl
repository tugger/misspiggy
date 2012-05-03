<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    
    <xsl:template match="estimation">
        <html>
            <head>
                <title>Estimation Report</title>
            </head>
            <body>
                <h2>Estimation Result</h2>
                <p><xsl:value-of select="project/effort/ph"/> ph = <xsl:value-of select="project/effort/pd"/> pd = <xsl:value-of select="project/effort/pm"/> pm = <xsl:value-of select="project/effort/py"/> py</p>
                <h3>Notes:</h3>
                <p><xsl:value-of select="project/effort/notes"/></p>
                <h2>Estimation Basis:</h2>
                <table>
                    <tr>
                        <td><strong>Type</strong></td>
                        <td><strong>Value</strong></td>
                    </tr>
                    <xsl:for-each select="project/characteristic">
                        <tr>
                            <td><xsl:value-of select="@name" /></td>
                            <td><xsl:value-of select="@value" /></td>
                        </tr>
                    </xsl:for-each>
                    <tr>
                        <td>Size</td>
                        <td><xsl:value-of select="project/size"/> kLOC</td>
                    </tr>
                </table>
                <h2>Similar projects</h2>
                <table>
                    <tr>
                        <td>#</td>
                        <td>Similarity</td>
                        <td>Size (kLOC)</td>
                        <td>Actual Effort</td>
                        <xsl:for-each select="similar/characteristics/item">
                            <td><xsl:value-of select="@name" /></td>
                        </xsl:for-each>
                    </tr>
                    <xsl:for-each select="similar/project">
                        <tr>
                        <td><xsl:value-of select="@number" /></td>
                        <td><xsl:value-of select="@similarity" />%</td>
                        <td><xsl:value-of select="@size" /></td>
                        <td><xsl:value-of select="@effort" /> pm</td>
                        <xsl:for-each select="characteristic">
                            <td><xsl:value-of select="@value" /></td>
                        </xsl:for-each>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
