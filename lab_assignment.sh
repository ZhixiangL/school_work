#!/bin/sh

IP_REGEX='^([0-9]{1,3}\.){3}[0-9]{1,3}$'
mail_regex="^[a-z0-9!#\$%&'*+/=?^_\`{|}~-]+(\.[a-z0-9!#$%&'*+/=?^_\`{|}~-]+)*@([a-z0-9]([a-z0-9-]*[a-z0-9])?\.)+[a-z0-9]([a-z0-9-]*[a-z0-9])?\$"
url_regex="^[w]{3}\.[a-z0-9A-Z.]+"
# #domain registrar
# domain_info=$(whois $1 | head -9)
# echo "Domain Info"
# whois $1 | head -9
# #DNS server
# whois $1 | grep "Name Server"

# dig $1 | grep -v \; > ip_info.txt
# #CNAME
# cname=$(awk '{ if($4 == "CNAME") print $5;}' ip_info.txt)
# echo "   CNAME: $cname"
# #IP
# ips=$(awk '{ if($4 == "A") print $5;}' ip_info.txt)
# echo "   IP addresses: "$ips

# #network and web hosting provider
# one_ip=$(awk '{ if($4 == "A") print $5;}' ip_info.txt | head -1 )
# whois $one_ip | grep \: | grep -v \# | head -11 | sed -e "s/^/   /g"


# #mail server
# dig mx $1 | grep -v \; > ip_info.txt
# mail_server=$(awk '{ if($4 == "MX") print $6;}' ip_info.txt)
# echo "   Mail servers: "$mail_server

touch output.txt
if [[ $1 =~ $IP_REGEX ]]; then
    echo "Net Info" >> output.txt
    whois $1 | grep \: | grep -v \# | head -11 | sed -e "s/^/   /g" >> output.txt
    echo "ISP info" >> output.txt
    whois $1 | grep \: | grep -v \# | tail -n +12 | head -10 | sed -e "s/^/   /g" >> output.txt
else
    if [[ $1 =~ $mail_regex ]]; then
        domain=$(echo $1 | cut -d@ -f2 )
    elif [[ $1 =~ $url_regex ]]; then
        domain=$(echo $1 | sed -e "s/www.//g" )
    else
        domain=$1
    fi

    echo "Domain Registrar Info" >> output.txt
    whois $domain | egrep \: | egrep "Domain Name|Date|Registry|Registrar|Registrant" | sed -e 's/^   //g' | sed -e 's/^/   /g' >> output.txt
    echo "Name Servers" >> output.txt
    whois $domain | grep "Name Server" | sed -e 's/^   //g' | sed -e 's/^/   /g' >> output.txt
    echo "Net Info" >> output.txt
    one_ip=$(dig $domain | grep -v \; | awk '{ if($4 == "A") print $5;}' | head -1 )
    whois $one_ip | grep \: | grep -v \# | head -11 | sed -e "s/^/   /g" >> output.txt
    echo "ISP info" >> output.txt
    whois $one_ip | grep \: | grep -v \# | tail -n +12 | head -10 | sed -e "s/^/   /g" >> output.txt


    mail_server=$(dig mx $domain | grep -v \; | awk '{ if($4 == "MX") print $6;}' )
    ips=$(dig $domain | grep -v \; | awk '{ if($4 == "A") print $5;}')
    echo "Other Info" >> output.txt
    echo "   IP addresses: "$ips >> output.txt
    echo "   Mail servers: "$mail_server >> output.txt
fi

cat output.txt
rm output.txt

